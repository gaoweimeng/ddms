package cn.wisdsoft.ddms.controller.teachercontroller;

import cn.wisdsoft.ddms.pojo.Basedata;
import cn.wisdsoft.ddms.pojo.Student;
import cn.wisdsoft.ddms.pojo.Teacher;
import cn.wisdsoft.ddms.service.baseDataService.BaseDataService;
import cn.wisdsoft.ddms.service.teacherservice.TeacherService;
import cn.wisdsoft.pojo.DdmsResult;
import cn.wisdsoft.pojo.PageResult;
import cn.wisdsoft.utils.*;
import org.apache.commons.collections4.map.LinkedMap;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>ClassName: TeacherController</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2018 /9/18 20:26
 */
@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {


    @Autowired
    private TeacherService teacherService;
    @Autowired
    private BaseDataService baseDataService;


    /**
     * 跳转教师页面
     *
     * @param
     * @return java.lang.String string
     * @date 20 :01 2018/9/26
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String teacherPage() {
        return "teacher/teacher_list";
    }

    /**
     * 添加教师
     *
     * @param result the result
     * @return cn.wisdsoft.pojo.DdmsResult ddms result
     * @throws
     * @date 10 :55 2018/9/19
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public DdmsResult addTeacher(String result) {
        Teacher teacher = JsonUtils.jsonToPojo(result, Teacher.class);
        return teacherService.addTeacher(teacher);
    }

    /**
     * 跳转添加页面
     *
     * @param
     * @return java.lang.String string
     * @date 20 :01 2018/9/26
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addTeacherPage(Model model) {
        List<Basedata> nation = baseDataService.selectBaseData("nation");
        model.addAttribute("nation", nation);
        return "teacher/teacher_add";
    }

    /**
     * 查询所有教师
     *
     * @param
     * @return cn.wisdsoft.pojo.DdmsResult ddms result
     * @throws
     * @date 11 :08 2018/9/19
     */
    @RequestMapping(value = "/queryall", method = RequestMethod.GET)
    @ResponseBody
    public DdmsResult queryAllTeacher() {
        return teacherService.queryAllTeacher();
    }

    /**
     * 更新教师信息
     *
     * @param result the result
     * @return cn.wisdsoft.pojo.DdmsResult ddms result
     * @throws
     * @date 16 :12 2018/9/19
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public DdmsResult updateTeacher(String result) {
        Teacher teacher = JsonUtils.jsonToPojo(result, Teacher.class);
        return teacherService.updateTeacher(teacher);
    }

    /**
     * 通过条件查询
     *
     * @param condition the condition
     * @return cn.wisdsoft.pojo.DdmsResult ddms result
     * @date 20 :31 2018/9/19
     */
    @RequestMapping(value = "/condition", method = RequestMethod.GET)
    @ResponseBody
    public DdmsResult queryCondition(String condition) {
        return teacherService.queryCondition(condition);
    }

    /**
     * 根据id删除教师信息
     *
     * @param id the id
     * @return cn.wisdsoft.pojo.DdmsResult ddms result
     * @date 20 :54 2018/9/19
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public DdmsResult del(String id) {
        return teacherService.deleteTeacher(id);
    }

    /**
     * 无条件分页
     *
     * @param page  当前页数
     * @param limit 显示行数
     * @return cn.wisdsoft.pojo.PageResult<cn.wisdsoft.ddms.pojo.Teacher> page result
     * @date 20 :24 2018/9/20
     */
    @RequestMapping(value = "/queryallpage", method = RequestMethod.GET)
    @ResponseBody
    public PageResult<Teacher> queryAllPageTeacher(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        return teacherService.queryAllPageTeacher(page, limit);
    }

    /**
     * 筛选分页
     *
     * @param page      当前页数
     * @param limit     显示行数
     * @param condition 过滤条件
     * @return cn.wisdsoft.pojo.PageResult<cn.wisdsoft.ddms.pojo.Teacher> page result
     * @date 20 :24 2018/9/20
     */
    @RequestMapping(value = "/queryconditionpage", method = RequestMethod.GET)
    @ResponseBody
    public PageResult<Teacher> queryConditionpagePageTeacher(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit, String condition) {
        return teacherService.queryConditionPageTeacher(page, limit, condition);
    }

    /**
     * 跳转编辑界面
     *
     * @param id    the id
     * @param model the model
     * @return java.lang.String string
     * @date 21 :18 2018/9/21
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String teacherEditPage(@PathVariable("id") String id, Model model) {
        Teacher teacher = teacherService.queryTeahcerId(id);
        List<Basedata> nation = baseDataService.selectBaseData("nation");
        model.addAttribute(teacher);
        model.addAttribute("nation", nation);
        return "teacher/teacher_edit";
    }

    /**
     * 导入Excel
     *
     * @param excelFile Excel文件
     * @return cn.wisdsoft.pojo.DdmsResult ddms result
     * @date 11 :12 2018/9/29
     */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    @ResponseBody
    public DdmsResult importExcel(MultipartFile excelFile) {
        try {
            Workbook xls = ImportUtil.getExcel(excelFile.getInputStream(), excelFile.getOriginalFilename());
            List<List<Object>> listByExcel = ImportUtil.getListByExcel(xls);
            return teacherService.importExcel(listByExcel);
        } catch (Exception e) {
            e.printStackTrace();
            return DdmsResult.build(500, e.getMessage());
        }
    }

    /**
     * Export excel.
     *
     * @param id       the id
     * @param response the response
     */
    @RequestMapping(value = "/exportExcel")
    @ResponseBody
    public void exportExcel(String[] id, HttpServletResponse response) {
        Map<String, String> map = new LinkedMap<>();
        map.put("worknumber", "工号");
        map.put("teaName", "教师名称");
        map.put("teaEnglishname", "英文名称");
        map.put("teaSex", "性别");
        map.put("teaBirthdate", "出生日期");
        map.put("teaPhone", "手机号");
        map.put("teaSparephone", "备用手机号");
        map.put("teaNation", "民族");
        map.put("teaNativeplace", "籍贯");
        map.put("teaAddress", "地址");
        map.put("teaPoliticalface", "政治面貌");
        map.put("teaIdcard", "身份证");
        map.put("teaMaritalstatus", "婚姻状态");
        map.put("teaDegreeedu", "教育程度");
        map.put("teaJobtitle", "职称");
        map.put("teaCjgzny", "参加工作年月");
        map.put("teaCjny", "从教年月");
        map.put("teaCredentialstime", "教师资格获取时间");
        map.put("teaCometime", "来校时间");
        map.put("teaRkzk", "任课状况");
        map.put("teaType", "教师类型");
        map.put("teaCampus", "校区");
        HSSFWorkbook excel = ExportUtil.createExcel("teacher", map);
        HSSFSheet oneHSSFSheet = null;
        try {
            oneHSSFSheet = Common.getOneHSSFSheet(excel, 0);
        } catch (Exception e) {
            System.out.println("没有工作簿");
        }
        List<Teacher> list = teacherService.selectByIdArrayTeacher(id);
        try {
            ExportUtil.fillCell(excel,oneHSSFSheet,list);
            Common.getExcel(excel,"人员",response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Download.
     *
     *
     * @param sheetNum the sheet num
     * @param rows     the rows
     * @param response the response
     */
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    @ResponseBody
    public void download(int sheetNum,int rows,HttpServletResponse response) {
        Map<String,String> map = new LinkedHashMap<>();
        map.put("worknumber", "工号");
        map.put("teaName", "教师名称");
        map.put("teaEnglishname", "英文名称");
        map.put("teaSex", "性别");
        map.put("teaBirthdate", "出生日期");
        map.put("teaPhone", "手机号");
        map.put("teaSparephone", "备用手机号");
        map.put("teaNation", "民族");
        map.put("teaNativeplace", "籍贯");
        map.put("teaAddress", "地址");
        map.put("teaPoliticalface", "政治面貌");
        map.put("teaIdcard", "身份证");
        map.put("teaMaritalstatus", "婚姻状态");
        map.put("teaDegreeedu", "教育程度");
        map.put("teaJobtitle", "职称");
        map.put("teaCjgzny", "参加工作年月");
        map.put("teaCjny", "从教年月");
        map.put("teaCredentialstime", "教师资格获取时间");
        map.put("teaCometime", "来校时间");
        map.put("teaRkzk", "任课状况");
        map.put("teaType", "教师类型");
        map.put("teaCampus", "校区");
        HSSFWorkbook excel = TempUtil.createExcel(sheetNum, map);
        List<Basedata> nation = baseDataService.selectBaseData("nation");
        String[] nations = new String[nation.size()];
        String[] types = {"外聘","本校"};
        String[] faces = {"团员","党员","群众"};
        List<HSSFSheet> sheets = null;
        try {
            sheets = Common.getAllHSSFSheet(excel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < nation.size(); i++) {
            nations[i] = nation.get(i).getName();
        }
        for (int j = 0; j < sheets.size(); j++) {
            try {
                TempUtil.setBoxes(1,rows,3,3,new String[]{"男","女"}, sheets.get(j));
                TempUtil.setBoxes(1,rows,7,7,nations, sheets.get(j));
                TempUtil.setBoxes(1,rows,10,10,faces, sheets.get(j));
                TempUtil.setBoxes(1,rows,20,20,types, sheets.get(j));
                int[] x = new int[]{5,6,11};
                TempUtil.setCellFormat(1,rows,x,excel,sheets.get(j));
                TempUtil.setDate(1,rows,4,4,"1900-01-01","2999-01-01","yyyy-mm-dd",sheets.get(j),excel);
                TempUtil.setDate(1,rows,15,18,"1900-01-01","2999-01-01","yyyy-mm-dd",sheets.get(j),excel);
                TempUtil.setLength(1,rows,5,6,sheets.get(j),excel,"11","手机号");
                TempUtil.setLength(1,rows,11,11,sheets.get(j),excel,"18","身份证号");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            Common.getExcel(excel,"人员",response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
