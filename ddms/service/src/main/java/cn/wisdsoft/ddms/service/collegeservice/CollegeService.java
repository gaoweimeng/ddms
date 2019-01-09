package cn.wisdsoft.ddms.service.collegeservice;

import cn.wisdsoft.ddms.pojo.College;
import cn.wisdsoft.pojo.DdmsResult;
import cn.wisdsoft.pojo.PageResult;

import java.util.List;

/**
 * @Author 李泽宇
 * @Description //TODO
 * @Date 2018/9/19 20:46
 * @Param
 * @return
 **/
public interface CollegeService {
    /**
     * @return
     * @Author 李泽宇
     * @Description //TODO 添加学院信息
     * @Date 2018/9/19 20:48
     * @Param
     **/
    DdmsResult addCollege(College college);

    /**
     * @return
     * @Author 李泽宇
     * @Description //TODO 删除学院信息
     * @Date 2018/9/19 20:48
     * @Param
     **/
    DdmsResult delCollege(String id);

    /**
     * @return
     * @Author 李泽宇
     * @Description //TODO 更改学院信息
     * @Date 2018/9/19 20:49
     * @Param
     **/
    DdmsResult updateCollege(College college);

    /**
     * @return
     * @Author 李泽宇
     * @Description //TODO 查询所有学院信息（分页）
     * @Date 2018/9/19 20:49
     * @Param
     **/
    PageResult<College> queryAllCollege(int rows, int limit);

    /**
     * @return
     * @Author 李泽宇
     * @Description //TODO根据ID查询学院信息
     * @Date 2018/9/25 16:29
     * @Param
     **/
    List<College> selectCollegeAccrodingtoid(String id);

    /**
     * @return
     * @Author 李泽宇
     * @Description //TODO 查询所有学院
     * @Date 2018/9/25 16:38
     * @Param
     **/
    List<College> selcollege();

    /**
     * @return
     * @Author 李泽宇
     * @Description //TODO 根据名称查询学院信息
     * @Date 2018/9/25 16:48
     * @Param
     **/
    PageResult<College> queryCollegeByName(College college, int rows, int limit);

    /**
     * @return
     * @Author 李泽宇
     * @Description //TODO 查询最大id
     * @Date 2018/9/27 19:37
     * @Param
     **/
    String selcollegemaxid();

    /**
     * @Author 李泽宇
     * @Description //TODO 批量导入
     * 此功能停用
     * @Date 2018/9/29 16:19
     * @Param
     * @return
     **/
//     int insertpiliang(List<String[]> list);
}
