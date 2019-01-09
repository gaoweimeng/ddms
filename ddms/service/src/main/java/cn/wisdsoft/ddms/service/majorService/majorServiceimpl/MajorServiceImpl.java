package cn.wisdsoft.ddms.service.majorService.majorServiceimpl;

import cn.wisdsoft.ddms.mapper.basedata.BasedataMapper;
import cn.wisdsoft.ddms.mapper.college.CollegeMapper;
import cn.wisdsoft.ddms.mapper.major.MajorMapper;
import cn.wisdsoft.ddms.pojo.College;
import cn.wisdsoft.ddms.pojo.CollegeExample;
import cn.wisdsoft.ddms.pojo.Major;
import cn.wisdsoft.ddms.pojo.MajorExample;
import cn.wisdsoft.ddms.pojo.MajorExample.Criteria;
import cn.wisdsoft.ddms.service.majorService.MajorService;
import cn.wisdsoft.pojo.DdmsResult;
import cn.wisdsoft.pojo.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 宋军伟
 * @datatime 2018年9月19日 上午10:40:34
 * @file_name CollegeServiceImpl.java
 * @describe
 */
@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private CollegeMapper collegeMapper;

    /*
     * songjunwei 2018年9月19日 上午11:02:57 描述：对专业信息进行添加
     */
    @Override
    public DdmsResult addMajor(Major major) {
        // CollegeExample example = new CollegeExample();
        // Criteria criteria = example.createCriteria();
        majorMapper.insert(major);
        return DdmsResult.ok();
    }

    /*
     * 描述：分页查询所有专业信息 songjunwei 2018年9月19日 上午11:11:28
     */
    @Override
    public PageResult<Major> selectByRowsAndlimit(int page, int limit) {
        // 分页参数 页数，每页行数
        PageHelper.startPage(page, limit);
        List<Major> major = majorMapper.selectByRowsAndlimit();
        // 获取记录总条数
        PageInfo<Major> pageInfo = new PageInfo<>(major);
        return PageResult.ok(major, pageInfo.getTotal());
    }

    /*
     *
     * 描述：更新数据库信息 songjunwei 2018年9月19日 下午3:57:26
     */
    @Override
    public DdmsResult updateMajor(Major major) {
        majorMapper.updateByPrimaryKey(major);
        return DdmsResult.ok();
    }

    /*
     *
     * 描述： 对传入的ID，删除行 songjunwei 2018年9月20日 上午11:31:14
     */
    @Override
    public DdmsResult deleteMajor(String id) {
        majorMapper.deleteByPrimaryKey(id);
        return DdmsResult.ok();
    }

    /*
     *
     * 描述：对专业名称 或者 教育程度进行查询 songjunwei 2018年9月20日 下午12:07:21
     */
    @SuppressWarnings("unchecked")
    @Override
    public PageResult<Major> selectByEducationOrName(Major major, int page, int limit) {
        // 分页参数页数，每页行数
        PageHelper.startPage(page, limit);
        List<Major> list = majorMapper.selectByEducationOrName(major);
        PageInfo<Major> info = new PageInfo<>(list);
        return PageResult.ok(list, info.getTotal());
    }

    @Override
    public DdmsResult selByEduOrName(Major major) {
        List<Major> list = majorMapper.selectByEducationOrName(major);
        return DdmsResult.ok(list);
    }

    /*
     * 描述：根据主键id，查询专业信息 songjunwei 2018年9月21日 下午5:53:05
     */
    @Override
    public List<Major> selectMajorAccrodingtoid(String id) {
        MajorExample example = new MajorExample();
        Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Major> major = majorMapper.selectByExample(example);
        return major;
    }

    /*
     * 描述：查询学院信息 songjunwei 2018年9月22日 下午10:17:43
     */
    @Override
    public List<College> selcollege() {
        CollegeExample example = new CollegeExample();
        List<College> list = collegeMapper.selectByExample(example);
        return list;
    }

    /*
     *
     * 描述：查询最大专业id songjunwei 2018年9月23日 下午12:55:00
     */
//    @Override
//    public String selmajormaxid() {
//        synchronized (this) {
//            String maxid = majorMapper.selmajormaxid();
//            String idvalue = null;
//            if (maxid != null && !"".equals(maxid)) {
//                String a = maxid.substring(0, 4);
//                String b = maxid.substring(maxid.length() - 4);
//                int num = Integer.parseInt(b);
//                //计算有几个0开头
//                int size = b.length() - String.valueOf(num).length();
//                if (size == 3) {
//                    int c = Integer.parseInt(b.substring(3));
//                    if (c == 9) {
//                        idvalue = a + "00" + (c + 1);
//                    } else {
//                        idvalue = a + "000" + (c + 1);
//                    }
//                } else if (size == 2) {
//                    int c = Integer.parseInt(b.substring(2));
//                    if (c == 99) {
//                        idvalue = a + "0" + (c + 1);
//                    } else {
//                        idvalue = a + "00" + (c + 1);
//                    }
//                } else if (size == 1) {
//                    int c = Integer.parseInt(b.substring(1));
//                    if (c >= 999) {
//                        idvalue = a + (c + 1);
//                    } else {
//                        idvalue = a + "0" + (c + 1);
//                    }
//                } else {
//                    idvalue = "数值大于9999，请联系管理员";
//                }
//            } else {
//                idvalue = "HGMJ0001";
//            }
//            return idvalue;
//        }
//
//    }

    /**
     * 描述：无条件查询所有数据 songjunwei 2018年9月24日 下午9:29:06
     */
    @Override
    public DdmsResult selallmajor() {
        // MajorExample example = new MajorExample();
        // List<Major> list = majorMapper.selectByExample(example);\
        List<Major> list = majorMapper.selectByRowsAndlimit();
        return DdmsResult.ok(list);
    }

    /*
     *
     * 描述：将数据保存到major中，将数据传输出去 songjunwei 2018年9月26日 下午7:09:13
     */
//    @Override
//    public int insertpiliang(String college,List<String[]> list) {
//        int i = 0;
        // File xlsfile = new File(filePath);
        // 1.实例化pojo类
//		List<Major> lists = new ArrayList<Major>();
        //Major major = new Major();
//		for(int i=0;i<list.size();i++) {
//			Map<String, Object> map = new HashMap<>();
//			//3.将获取的行放到pojo类中
//			String[] strings = list.get(i);
//			major.setMajorName(strings[0]);
//			major.setMajorCollegeid(strings[1]);
//			major.setMajorDisciplinecategories(strings[2]);
//			major.setMajorEducation(strings[3]);
//			int schoolsystem = Integer.parseInt(strings[4]);
//			major.setSchoolsystem(schoolsystem);
//			//4.将对象保存到Major中，发送出去
//			major.setId(selmajormaxid());
//			map.put("list", major);
//			lists.add((Major) map);
//		}				
//        try {
//            i = majorMapper.insertSalesMajor(college,list);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return i;
//    }
    @Override
    public int insertpiliang(List<String[]> list) {
        Map<String, String> map = new HashMap<>();
        College obj = new College();
        obj.setCollegeName("");
        List<College> colleges = collegeMapper.queryBycollegeName(obj);
        colleges.forEach(i -> map.put(i.getCollegeName(), i.getId()));
        int i = 0;
        List<String[]> zuMajor = new ArrayList<String[]>();
        Major major =new Major();
        int selecMaxId = this.SelecMaxId();
        for (int s=0;s<list.size();s++){
            if(list.get(s)[0]==null) {
                break;
            }
            String[] cells = new String[6];
            for(int x=0;x<6;x++){
               if(x==0){
                   cells[x]= this.selmajormaxid(selecMaxId+s+"");
               }else if(x==1){
                   //某一行的值
                   String[] strings = list.get(s);
                   cells[x]=strings[0];
               }else if(x==2){
                   cells[x] = map.get(list.get(s)[1]);
               } else if(x==3){
                   cells[3]=list.get(s)[2];
               } else if(x==4){
                   cells[4]=list.get(s)[3];
               } else if(x==5){
                   cells[5]=list.get(s)[4];
               }
            }
            zuMajor.add(cells);
        }
        try {
            i = majorMapper.insertSalesMajor(zuMajor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    public int SelecMaxId() {
        synchronized (this) {
            String maxid = majorMapper.selmajormaxid();
            int idvalue=0;
            if (maxid != null && !"".equals(maxid)) {
                String b = maxid.substring(maxid.length() - 4);
                int num = Integer.parseInt(b);
                //计算有几个0开头
                int size = b.length() - String.valueOf(num).length();
                if (size == 3) {
                    idvalue = Integer.parseInt(b.substring(3));
                } else if (size == 2) {
                    idvalue = Integer.parseInt(b.substring(2));
                } else if (size == 1) {
                    idvalue = Integer.parseInt(b.substring(1));
                } else {
                    idvalue = 9999;
                }
                idvalue = idvalue + 1;
            } else {
                idvalue = 1;
            }
            return idvalue;
        }
    }

    /**
     * 描述：查询最大专业id songjunwei
     * @return
     */
    public String selmajormaxid(String ma) {
        String MaxId=null;
        String Id=null;
        if(ma==null || "".equals(ma)){
            Id= this.SelecMaxId()+"";
        }else {
            Id=ma;
        }
        String maxid = majorMapper.selmajormaxid();
        String a = maxid.substring(0, 4);
        int size = Id.length();
        if(size<2){
            MaxId = a + "000" + Id;
        }else if(size==2){
            MaxId = a + "00" + Id;
        }else if(size==3){
            MaxId = a + "0" + Id;
        }else if(size==4){
            MaxId = a + Id;
        }else {
            MaxId = "数值大于9999，请联系管理员";
        }
        return MaxId;
    }
}
