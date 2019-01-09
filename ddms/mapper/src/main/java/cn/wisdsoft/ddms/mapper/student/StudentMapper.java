package cn.wisdsoft.ddms.mapper.student;

import cn.wisdsoft.ddms.pojo.Student;
import cn.wisdsoft.ddms.pojo.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * The interface Student mapper.
 */
public interface StudentMapper {
    /**
     * Count by example long.
     *
     * @param example the example
     * @return the long
     */
    long countByExample(StudentExample example);

    /**
     * Delete by example int.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(StudentExample example);

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
    int insert(Student record);

    /**
     * Insert selective int.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(Student record);

    /**
     * Select by example with blo bs list.
     *
     * @param example the example
     * @return the list
     */
    List<Student> selectByExampleWithBLOBs(StudentExample example);

    /**
     * Select by example list.
     *
     * @param example the example
     * @return the list
     */
    List<Student> selectByExample(StudentExample example);

    /**
     * Select by primary key student.
     *
     * @param id the id
     * @return the student
     */
    Student selectByPrimaryKey(String id);

    /**
     * Update by example selective int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    /**
     * Update by example with blo bs int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExampleWithBLOBs(@Param("record") Student record, @Param("example") StudentExample example);

    /**
     * Update by example int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    /**
     * Update by primary key selective int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * Update by primary key with blo bs int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeyWithBLOBs(Student record);

    /**
     * Update by primary key int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(Student record);

    /**
     * Select counts int.
     * 查询学生数据行数量
     *
     * @param delFlag the del flag
     * @return the int
     */
    int selectCounts(int delFlag);

    /**
     * Select all student list.
     * 查询所有的学生并分页
     *
     * @param page    the page
     * @param limit   the limit
     * @param delFlag the del flag
     * @return the list
     */
    List<Student> selectAllStudent(@Param("page") int page,@Param("limit")int limit,@Param("delFlag") int delFlag);

    /**
     * Filter counts int.
     * 通过条件筛选学生的总数据条数
     *
     * @param stuId    the stu id  学生ID
     * @param stuName  the stu name  学生姓名
     * @param stuMajor the stu major  学生专业
     * @param delFlag  the del flag  是否已删除
     * @return the int
     */
    int filterCounts(@Param("stuId") String stuId,@Param("stuName") String stuName,@Param("stuMajor") String stuMajor,@Param("delFlag") int delFlag);

    /**
     * Filter student list list.
     * 通过条件筛选学生
     *
     * @param stuId    the stu id  学生ID
     * @param stuName  the stu name  学生姓名
     * @param stuMajor the stu major  学生专业
     * @param delFlag  the del flag  是否已删除
     * @param page     the page  当前页数
     * @param limit    the limit  每页数量
     * @return the list
     */
    List<Student> filterStudentList(@Param("stuId") String stuId,@Param("stuName") String stuName,@Param("stuMajor") String stuMajor,@Param("delFlag") int delFlag,@Param("page") int page,@Param("limit") int limit);

    /**
     * Update student del flag int.
     * 更新学生的delFlag列
     *
     * @param id      the id  学生ID
     * @param delFlag the del flag  学生delFlag列的值
     * @return the int
     */
    int updateStudentDelFlag(@Param("id") String id,@Param("delFlag") int delFlag);

    /**
     * Restore student int.
     * 学生数据恢复
     *
     * @param id the id  学生ID
     * @return the int
     */
    int restoreStudent(String[] id);

    /**
     * Select student by ids list.
     * 通过ID数组查询学生
     *
     * @param id the id  学生ID数组
     * @return the list
     */
    List<Student> selectStudentByIds(String[] id);

    int insertExcelList(@Param("list") List list);

}