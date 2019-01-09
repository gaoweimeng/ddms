package cn.wisdsoft.ddms.mapper.clazz;

import cn.wisdsoft.ddms.pojo.Clazz;
import cn.wisdsoft.ddms.pojo.ClazzExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClazzMapper {
    int countByExample(ClazzExample example);

    int deleteByExample(ClazzExample example);

    int deleteByPrimaryKey(String id);

    int insert(Clazz record);

    int insertSelective(Clazz record);

    List<Clazz> selectByExample(ClazzExample example);

    Clazz selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Clazz record, @Param("example") ClazzExample example);

    int updateByExample(@Param("record") Clazz record, @Param("example") ClazzExample example);

    int updateByPrimaryKeySelective(Clazz record);

    int updateByPrimaryKey(Clazz record);

    /**
     * @return
     * @Author 李泽宇
     * @Description //TODO 通过班级名称或者专业名称（和专业表联合查询）模糊查询班级信息
     * @Date 2018/9/19 21:30
     * @Param
     **/
    List<Clazz> selectByclazzNameOrmajorName(Clazz clazz);

    /**
     * @return
     * @Author 李泽宇
     * @Description //TODO 根据id查班级名称（高伟萌要的方法1）
     * @Date 2018/9/20 16:28
     * @Param
     **/
    Clazz selectNameById(String id);

    /**
     * @return
     * @Author 李泽宇
     * @Description //TODO 根据班级名称查询id（高伟萌要的方法2）
     * @Date 2018/9/26 8:09
     * @Param
     **/
    Clazz selectIdByName(String clazzName);

    /**
     * @return
     * @Author 李泽宇
     * @Description //TODO 查询所有名称（高伟萌要的方法3）
     * @Date 2018/9/26 8:11
     * @Param
     **/
    List<Clazz> selectAllName();

    /**
     * @return
     * @Author 李泽宇
     * @Description //TODO 查询所有和班级有关的信息
     * @Date 2018/9/26 17:51
     * @Param
     **/
    List<Clazz> selectAllClazz();

    /**
     * @return
     * @Author 李泽宇
     * @Description //TODO 查询最大id
     * @Date 2018/9/27 20:01
     * @Param
     **/
    String selclazzmaxid();

    /**
     * @Author 李泽宇
     * @Description //TODO 插入信息，留着导入用
     * 此功能停用
     * @Date 2018/9/29 17:18
     * @Param
     * @return
     **/
//    int insertSalesClazz(@Param("list") List<String[]> list);
}