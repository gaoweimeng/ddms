package cn.wisdsoft.ddms.mapper.major;

import cn.wisdsoft.ddms.pojo.Major;
import cn.wisdsoft.ddms.pojo.MajorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Major mapper.
 */
public interface MajorMapper {
    /**
     * Count by example int.
     *
     * @param example the example
     * @return the int
     */
    int countByExample(MajorExample example);

    /**
     * Delete by example int.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(MajorExample example);

    /**
     * Delete by primary key int.
     *
     * @param id the id
     * @return the int
     */
    int deleteByPrimaryKey(String id);

    /**
     * Insert int.
     *
     * @param record the record
     * @return the int
     */
    int insert(Major record);

    /**
     * Insert selective int.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(Major record);

    /**
     * Select by example list.
     *
     * @param example the example
     * @return the list
     */
    List<Major> selectByExample(MajorExample example);

    /**
     * Select by primary key major.
     *
     * @param id the id
     * @return the major
     */
    Major selectByPrimaryKey(String id);

    /**
     * Update by example selective int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") Major record, @Param("example") MajorExample example);

    /**
     * Update by example int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") Major record, @Param("example") MajorExample example);

    /**
     * Update by primary key selective int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(Major record);

    /**
     * Update by primary key int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(Major record);

    /**
     * 根据学历和专业名字查询专业
     * songjunwei
     * 2018年9月23日 下午12:32:41
     *
     * @param major the major
     * @return list
     */
    List<Major> selectByEducationOrName(Major major);

    /**
     * 分页查询数据
     * songjunwei
     * 2018年9月23日 下午12:34:10
     *
     * @return list
     */
    List<Major> selectByRowsAndlimit();

    /**
     * 查询专业的最大id
     * songjunwei
     * 2018年9月23日 下午12:36:34
     *
     * @return string
     */
    String selmajormaxid();

    /**
     * Insert sales major int.
     *
     * @param list the list
     * @return int int
     * @date 20 :53 2018/9/28
     */
    int insertSalesMajor(@Param("list") List<String[]> list);

    /**
     * 根据名称查询ID（student需要）
     * 高伟萌
     * 2018年9月23日 下午12:36:34
     *
     * @param majorName the major name
     * @return major
     */
    Major selectIdByName(String majorName);

    /**
     * 查询所有名称（student需要）
     * 高伟萌
     * 2018年9月23日 下午12:36:34
     *
     * @return list
     */
    List<Major> selectAllName();

    /**
     * 根据专业编号查询学制（student需要）<br>
     * 高伟萌<br>
     * 2018年9月23日 下午12:36:34
     *
     * @return list
     */
    String selectTimeByMajorId(String majorId);

    /**
     * 根据专业ID查询专业名称（student需要）<br>
     * 高伟萌<br>
     * 2018年9月23日 下午12:36:34
     *
     * @return list
     */
    String selectMajorIdByMajorName(String majorName);

    String selectMajorNameByMajorId(String id);
}