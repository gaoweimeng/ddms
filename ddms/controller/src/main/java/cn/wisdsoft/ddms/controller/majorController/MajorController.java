package cn.wisdsoft.ddms.controller.majorController;

import cn.wisdsoft.ddms.pojo.Basedata;
import cn.wisdsoft.ddms.pojo.College;
import cn.wisdsoft.ddms.pojo.Major;
import cn.wisdsoft.ddms.service.baseDataService.BaseDataService;
import cn.wisdsoft.ddms.service.collegeservice.CollegeService;
import cn.wisdsoft.ddms.service.majorService.MajorService;
import cn.wisdsoft.pojo.DdmsResult;
import cn.wisdsoft.pojo.PageResult;
import cn.wisdsoft.utils.Common;
import cn.wisdsoft.utils.InsertUtils;

import cn.wisdsoft.utils.TempUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 专业controller
 * @author 宋军伟
 * @datatime 2018年9月19日 下午4:07:52
 * @file_name MajorController.java
 * @describe
 */
@Controller
@RequestMapping("/major")
public class MajorController {

    @Autowired
    private MajorService majorService;
    @Autowired
    private BaseDataService baseDataService;
    @Autowired
    private CollegeService collegeService;

    /**
     * 跳转到major专业表 songjunwei 2018年9月20日 下午7:43:19
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView openListMajor() {
        ModelAndView model =new  ModelAndView();
        List<College> result = majorService.selcollege();
        model.addObject("college", result);
        model.setViewName("/major/major_list");
        return model;
    }

    /**
     * 分页查询所有专业 songjunwei
     * 2018年9月19日 下午4:16:54
     * @return DdmsResult格式数据
     */
    @RequestMapping(value = "/selmajor", method = RequestMethod.GET)
    @ResponseBody
    public PageResult<Major> selectByRowsAndLimit(int page, int limit) {
        return majorService.selectByRowsAndlimit(page, limit);
    }

    /**
     * 添加专业信息 songjunwei
     * 2018年9月19日 下午6:44:01
     * @param major
     * @return DdmsResult格式数据
     */
    @RequestMapping(value = "/addmajor", method = RequestMethod.POST)
    @ResponseBody
    public DdmsResult addMajor(Major major) {
        major.setId(majorService.selmajormaxid(null));
        return majorService.addMajor(major);
    }

    /**
     * 修改专业信息 songjunwei 2018年9月19日 下午7:55:48
     * @param major
     * @return
     */
    @RequestMapping(value = "/updatemajors", method = RequestMethod.POST)
    @ResponseBody
    public DdmsResult updateMajor(Major major) {
        return majorService.updateMajor(major);
    }

    /**
     * 通过专本科或专业名称查询 分页 songjunwei 2018年9月20日 下午5:13:25
     * @param major
     * @return
     */
    @RequestMapping(value = "/selectByEducationOrName", method = RequestMethod.GET)
    @ResponseBody
    public PageResult<Major> selectByEducationOrName(Major major, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        return majorService.selectByEducationOrName(major, page, limit);

    }

    /**
     * 批量导出
     * @param major
     * @return
     */
    @RequestMapping(value = "/selByEduOrName", method = RequestMethod.POST)
    @ResponseBody
    public DdmsResult selByEduOrName(Major major) {
        return majorService.selByEduOrName(major);

    }

    /**
     * 根据主键id删除行 songjunwei 2018年9月21日 下午5:08:01
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delemajor", method = RequestMethod.POST)
    @ResponseBody
    public DdmsResult deleteMajor(String id) {
        return majorService.deleteMajor(id);
    }

    /**
     * 根据id查询major信息 songjunwei 2018年9月21日 下午5:56:08 修改：2018年9月23日 上午9:00:08
     *
     * @param
     * @return {"status":200,"msg":"OK","data":{id
     * majorName,majorCollegeid,majorDisciplinecategories
     * majorEducation,schoolsystem}}
     */
    @RequestMapping(value = "/selectMajorAccrodingtoid", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView selectMajorAccrodingtoid(String id) {
        ModelAndView view = new ModelAndView();
        // int id = Integer.parseInt(ids);
        List<Major> major = majorService.selectMajorAccrodingtoid(id);
        List<College> selcollege = majorService.selcollege();
        //查询所有学科门类subject
        List<Basedata> subject = baseDataService.selectBaseData("subject");
        //查询所有学历education
        List<Basedata> education = baseDataService.selectBaseData("education");
        view.addObject("collegename", selcollege);
        view.addObject("majorresult", major);
        view.addObject("subject",subject);
        view.addObject("education",education);
        view.setViewName("/major/major_update");
        return view;
    }

    /**
     * 跳转增加专业信息页面 songjunwei 2018年9月22日 下午18:34
     *
     * @return 增加专业信息页面
     */
    // @RequestMapping(value="/addmajorpage",method=RequestMethod.GET)
    // public String openmajor_add() {
    // return "/major/major_add";
    // }

    /**
     * 查询学院信息,专业数据subject，学历数据education
     * songjunwei
     * 2018年9月22日 下午10:20:24
     *
     * @return
     */
    @RequestMapping(value = "/selcollege", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView selectCollege() {
        ModelAndView view = new ModelAndView();
        List<College> result = majorService.selcollege();
        //查询所有学科门类subject
        List<Basedata> subject = baseDataService.selectBaseData("subject");
        //查询所有学历education
        List<Basedata> education = baseDataService.selectBaseData("education");
        System.out.println(subject);
        view.addObject("list", result);
        view.addObject("subject",subject);
        view.addObject("education",education);
        view.setViewName("/major/major_add");
        return view;
    }

    /**
     * 无条件查询所有数据 songjunwei 2018年9月24日 下午9:31:34
     *
     * @return
     */
    @RequestMapping(value = "/selallmajor", method = RequestMethod.GET)
    @ResponseBody
    public DdmsResult selallmajor() {
        return majorService.selallmajor();
    }

    /**
     * 用EXCL批量插入数据 songjunwei 2018年9月26日 下午7:18:25
     *
     * @param filePath
     * @return
     */
    @RequestMapping(value = "/readExcelData", method = RequestMethod.POST)
    @ResponseBody
    public DdmsResult readExcelData(MultipartFile filePath) {
        try {
            //File file = new File("D:\\1.xls");
//            InputStream in = new FileInputStream(filePath);
            InputStream inputStream = filePath.getInputStream();
            String fileName = filePath.getOriginalFilename();
            List<String[]> list = InsertUtils.readExcel(inputStream, fileName);
            majorService.insertpiliang(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return DdmsResult.ok();
    }

    /**
     * 下载专业模板
     * @param sheetName 工作簿名称
     * @param response
     */
    @RequestMapping(value = "updataDownLoad",method = RequestMethod.POST)
    @ResponseBody
    public void updateDownLoad(int sheetName, HttpServletResponse response) {
        try {
//            String[] header = new String[]{"专业名称","学院","学科门类", "学历", "学制"};
            Map<String,String> map = new LinkedHashMap<>();
            map.put("123","专业名称");
            map.put("456","学院");
            map.put("789","学科门类");
            map.put("852","学历");
            map.put("741","学制");
            HSSFWorkbook excel = TempUtil.createExcel(sheetName, map);
            HSSFSheet hssfSheet = Common.getOneHSSFSheet(excel, 0);
            //查询所有学科门类subject
            List<Basedata> subject = baseDataService.selectBaseData("subject");
            //查询所有学历education
            List<Basedata> education = baseDataService.selectBaseData("education");
            //查询所有的学院 college
            List<College> collegeList = collegeService.selcollege();

            String[] sub = new String[subject.size()];
            for (int i = 0; i < subject.size(); i++) {
                sub[i] = subject.get(i).getName();
            }
            String[] edu = new String[education.size()];
            for (int i = 0; i < education.size(); i++) {
                edu[i] = education.get(i).getName();
            }
            String[] coll = new String[collegeList.size()];
            for (int i = 0; i < collegeList.size(); i++) {
                coll[i] = collegeList.get(i).getCollegeName();
            }
            int[] x = new int[]{3};
            TempUtil.setBoxes(1, 1000, 1, 1, coll, hssfSheet);
            TempUtil.setBoxes(1, 1000, 2, 2, sub, hssfSheet);
            TempUtil.setBoxes(1, 1000, 3, 3, edu, hssfSheet);
            TempUtil.setCellFormat(1, 1000, x, excel, hssfSheet);
            Common.getExcel(excel, "专业模板", response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
