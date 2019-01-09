package cn.wisdsoft.ddms.controller.student;

import cn.wisdsoft.ddms.pojo.Basedata;
import cn.wisdsoft.ddms.pojo.Major;
import cn.wisdsoft.ddms.pojo.Student;
import cn.wisdsoft.ddms.service.baseDataService.BaseDataService;
import cn.wisdsoft.ddms.service.students.StudentService;
import cn.wisdsoft.pojo.DdmsResult;
import cn.wisdsoft.pojo.PageResult;
import cn.wisdsoft.utils.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * @ Author     ：高伟萌
 * @ Date       ：Created in 2018/9/20 12:48
 * @ Description：学生控制器
 * @ Modified By：
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private BaseDataService baseDataService;

    /**
     * Index string.
     * 跳转至学生列表页面
     *
     * @return the string
     */
    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        List<Major> majors = studentService.selectAllMajorName();
        mav.addObject("allMajor", majors);
        mav.setViewName("student/student_list");
        return mav;
    }

    /**
     * Select all student ddms result.
     * 查询所有学生信息显示到列表
     *
     * @param page    the page  当前页数
     * @param limit   the limit  每页数量
     * @param delFlag the del flag
     * @return the ddms result
     */
    @RequestMapping(value = "selectAllStudent", method = RequestMethod.GET)
    @ResponseBody
    public PageResult selectAllStudent(int page, int limit, int delFlag) {
        if (page == 1) {
            page = 0;
        } else {
            page = (page - 1) * 10;
        }
        return studentService.selectAllStudent(page, limit, delFlag);
    }

    /**
     * Open add page model and view.
     * 进入添加学生页面
     *
     * @return the model and view
     */
    @RequestMapping("openAddPage")
    public ModelAndView openAddPage() {
        ModelAndView mav = common();
        mav.setViewName("student/student_add");
        return mav;
    }

    /**
     * Select school system ddms result.
     * 查询专业所对应学制
     *
     * @param majorId the major id  专业ID
     * @return the ddms result
     */
    @RequestMapping("selectSchoolSystem")
    @ResponseBody
    public DdmsResult selectSchoolSystem(String majorId) {
        return DdmsResult.ok(studentService.selectTimeByMajorId(majorId));
    }

    /**
     * Insert one student ddms result.
     * 插入单条学生信息
     *
     * @param students the students  学生JSON字符串
     * @return the ddms result
     */
    @RequestMapping(value = "insertOneStudent", method = RequestMethod.POST)
    @ResponseBody
    public DdmsResult insertOneStudent(String students) {
        Student student = JsonUtils.jsonToPojo(students, Student.class);
        return studentService.insertOneStudent(student);
    }

    /**
     * Open see page model and view.
     * 跳转至查看页面
     *
     * @param id the id  学生ID
     * @return the model and view
     */
    @RequestMapping(value = "openSeePage", method = RequestMethod.GET)
    public ModelAndView openSeePage(String id) {
        ModelAndView mav = new ModelAndView();
        DdmsResult result = studentService.selectOneStudent(id);
        mav.addObject("oneStudent", result);
        mav.setViewName("student/student_see");
        return mav;
    }

    /**
     * Open edit page model and view.
     * 跳转至编辑页面
     *
     * @param id the id  学生ID
     * @return the model and view
     */
    @RequestMapping(value = "openEditPage", method = RequestMethod.GET)
    public ModelAndView openEditPage(String id) {
        ModelAndView mav = common();
        DdmsResult result = studentService.selectOneStudent(id);
        mav.addObject("oneStudent", result);
        mav.setViewName("student/student_edit");
        return mav;
    }

    /**
     * Update student ddms result.
     * 更新单条学生信息
     *
     * @param student the student  学生POJO类
     * @return the ddms result
     */
    @RequestMapping(value = "updateStudent", method = RequestMethod.POST)
    @ResponseBody
    public DdmsResult updateStudent(String student) {
        Student pojo = JsonUtils.jsonToPojo(student, Student.class);
        return studentService.updateOneStudent(pojo);
    }

    /**
     * Filter student list page result.
     * 筛选学生信息
     *
     * @param stuId    the stu id  学生ID
     * @param stuName  the stu name  学生姓名
     * @param stuMajor the stu major  学生专业
     * @param delFlag  the del flag  是否删除
     * @param page     the page
     * @param limit    the limit
     * @return the page result
     */
    @RequestMapping(value = "filterStudentList", method = RequestMethod.GET)
    @ResponseBody
    public PageResult filterStudentList(String stuId, String stuName, String stuMajor, int delFlag, int page, int limit) {
        if (page == 1) {
            page = 0;
        } else {
            page = (page - 1) * 10;
        }
        return studentService.filterStudentList(stuId, stuName, stuMajor, delFlag, page, limit);
    }

    /**
     * Delete student first ddms result.
     * 将学生添加至回收站（将delFlag列由0改为1）
     *
     * @param id the id  学生ID
     * @return the ddms result
     */
    @RequestMapping(value = "deleteStudentFirst", method = RequestMethod.POST)
    @ResponseBody
    public DdmsResult deleteStudentFirst(String id) {
        return studentService.deleteStudentFirst(id, 1);
    }

    /**
     * Open del page model and view.
     * 打开数据恢复页面
     *
     * @return the model and view
     */
    @RequestMapping("openDelPage")
    public ModelAndView openDelPage(){
        ModelAndView mav = new ModelAndView();
        List<Major> majors = studentService.selectAllMajorName();
        mav.setViewName("student/student_del");
        mav.addObject("allMajor",majors);
        return mav;
    }

    /**
     * Delete student second ddms result.
     * 从数据库删除学生信息
     *
     * @param id the id  学生ID
     * @return the ddms result
     */
    @RequestMapping(value = "deleteStudentSecond",method = RequestMethod.POST)
    @ResponseBody
    public DdmsResult deleteStudentSecond(String id){
        return studentService.deleteStudentSecond(id);
    }

    /**
     * Restore student ddms result.
     * 学生数据恢复
     *
     * @param id the id  学生ID
     * @return the ddms result
     */
    @RequestMapping(value = "restoreStudent",method = RequestMethod.POST)
    @ResponseBody
    public DdmsResult restoreStudent(String[] id){
        return studentService.restoreStudent(id);
    }

    /**
     * Down load.
     * 下载模板
     *
     * @param sheetNum the sheet num  工作簿数量
     * @param response the response  响应
     */
    @RequestMapping("downLoad")
    @ResponseBody
    public void downLoad(int sheetNum,int rows,HttpServletResponse response){
        Map<String,String> map = new LinkedHashMap<>();
        map.put("id","学号");
        map.put("stuName","姓名");
        map.put("stuSex","性别");
        map.put("stuBirthday","出生日期");
        map.put("stuEntranceTime","入学时间");
        map.put("stuPoliticalface","政治面貌");
        map.put("stuFamilynumber","家庭电话");
        map.put("stuAddress","家庭住址");
        map.put("stuPhone","手机号");
        map.put("stuIdcard","身份证号");
        map.put("stuMajorId","专业");
        map.put("stuNational","民族");
        HSSFWorkbook excel = TempUtil.createExcel(sheetNum, map);
        List<Major> majors = studentService.selectAllMajorName();
        List<Basedata> nation = baseDataService.selectBaseData("nation");
        String[] nations = new String[nation.size()];
        String[] majorNames = new String[majors.size()];
        String[] sexs = {"男","女"};
        List<HSSFSheet> sheets = null;
        try {
            sheets = Common.getAllHSSFSheet(excel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < majors.size(); i++) {
            majorNames[i] = majors.get(i).getMajorName();
        }
        for (int j = 0; j < nation.size(); j++) {
            nations[j] = nation.get(j).getName();
        }
        for (int j = 0; j < sheets.size(); j++) {
            try {
                TempUtil.setBoxes(1,rows,10,10,majorNames, sheets.get(j));
                TempUtil.setBoxes(1,rows,11,11,nations, sheets.get(j));
                TempUtil.setBoxes(1,rows,2,2,sexs, sheets.get(j));
                int[] x = new int[]{0,6,8,9};
                TempUtil.setCellFormat(1,rows,x,excel,sheets.get(j));
                TempUtil.setDate(1,rows,3,4,"1900-01-01","2099-01-01","yyyy-mm-dd",sheets.get(j),excel);
                TempUtil.setLength(1,rows,8,8,sheets.get(j),excel,"11","手机号");
                TempUtil.setLength(1,rows,9,9,sheets.get(j),excel,"18","身份证号");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            Common.getExcel(excel,"学生",response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Export excel.
     * 导出Excel
     *
     * @param id       the id  学生ID数组
     * @param response the response  响应
     */
    @RequestMapping("exportExcel")
    @ResponseBody
    public void exportExcel(String[] id,HttpServletResponse response){
        Map<String,String> map = new LinkedHashMap<>();
        map.put("id","学号");
        map.put("stuName","姓名");
        map.put("stuSex","性别");
        map.put("stuBirthday","出生日期");
        map.put("stuNative","籍贯");
        map.put("stuEntranceTime","入学时间");
        map.put("stuGraduationTime","毕业时间");
        map.put("stuPoliticalface","政治面貌");
        map.put("stuFamilynumber","家庭电话");
        map.put("stuAddress","家庭住址");
        map.put("stuPhone","手机号");
        map.put("stuQq","QQ号");
        map.put("stuIdcard","身份证号");
        map.put("majorName","专业");
        map.put("stuNational","民族");
        map.put("stuStatus","状态");
        map.put("stuProvince","生源省份");
        map.put("stuSource","生源地区");
        map.put("stuCulobject","培养对象");
        map.put("stuCulcategory","培养类别");
        map.put("stuSchooltype","办学类型");
        map.put("stuGradcategory","毕业类别");
        map.put("stuCandidatetype","考生类别");
        HSSFWorkbook excel = ExportUtil.createExcel("student", map);
        HSSFSheet oneHSSFSheet = null;
        try {
            oneHSSFSheet = Common.getOneHSSFSheet(excel, 0);
        } catch (Exception e) {
            System.out.println("没有工作簿");
        }
        List<Student> list = studentService.selectStudentByIds(id);
        try {
            ExportUtil.fillCell(excel,oneHSSFSheet,list);
            Common.getExcel(excel,"学生",response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("importExcel")
    @ResponseBody
    public DdmsResult importExcel(MultipartFile fileType){
        try {
            Workbook excel = ImportUtil.getExcel(fileType.getInputStream(), fileType.getOriginalFilename());
            List<List<Object>> listByExcel = ImportUtil.getListByExcel(excel);
            for(int i = 0;i<listByExcel.size();i++){
                String majorName = listByExcel.get(i).get(10).toString();
                String majorId = studentService.selectMajorNameByMajorId(majorName);
                DdmsResult result = studentService.selectTimeByMajorId(majorId);
                int data = Integer.parseInt(result.getData()+"");
                String stu_entranceTime = (String) listByExcel.get(i).get(4);
                String entr1 = stu_entranceTime.substring(0,4);
                int ente = Integer.parseInt(entr1);
                int grad = ente + data;
                String stu_graduationTime = grad + stu_entranceTime.substring(4,10);
                //stu_graduationTime
                listByExcel.get(i).set(10,majorId);
                listByExcel.get(i).add(stu_graduationTime);
                return studentService.insertExportList(listByExcel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DdmsResult ddmsResult = new DdmsResult();
        ddmsResult.setMsg("导入失败");
        ddmsResult.setStatus(500);
        return ddmsResult;
    }

    private ModelAndView common() {
        ModelAndView mav = new ModelAndView();
        List<Major> allMajorName = studentService.selectAllMajorName();
        List<Basedata> stuStatus = baseDataService.selectBaseData("stuStatus");
        List<Basedata> stuCulObject = baseDataService.selectBaseData("stuCulObject"); //培养对象
        List<Basedata> stuCulCategory = baseDataService.selectBaseData("stuCulCategory"); //培养类别
        List<Basedata> schoolType = baseDataService.selectBaseData("schoolType"); //办学类型
        List<Basedata> stuGradCategory = baseDataService.selectBaseData("stuGradCategory"); //毕业类别
        List<Basedata> candidateType = baseDataService.selectBaseData("candidateType"); //考生类别
        List<Basedata> nation = baseDataService.selectBaseData("nation");
        mav.addObject("allMajors", allMajorName);
        mav.addObject("stuStatus", stuStatus);
        mav.addObject("stuCulObjects", stuCulObject);
        mav.addObject("stuCulCategory", stuCulCategory);
        mav.addObject("schoolType", schoolType);
        mav.addObject("stuGradCategory", stuGradCategory);
        mav.addObject("candidateType", candidateType);
        mav.addObject("nation", nation);
        return mav;
    }
}
