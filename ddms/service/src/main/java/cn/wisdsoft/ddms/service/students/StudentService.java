package cn.wisdsoft.ddms.service.students;

import cn.wisdsoft.ddms.pojo.Major;
import cn.wisdsoft.ddms.pojo.Student;
import cn.wisdsoft.pojo.DdmsResult;
import cn.wisdsoft.pojo.PageResult;

import java.util.List;

/**
 * @ Author     ：高伟萌
 * @ Date       ：Created in 2018/9/20 13:06
 * @ Description：学生业务层
 * @ Modified By：
 */
public interface StudentService {

    /**
     * Select all student ddms result.
     * 查询所有学生信息
     *
     * @param page    the page  当前页数
     * @param limit   the limit  每页数量
     * @param delFlag the del flag
     * @return the ddms result
     */
    PageResult selectAllStudent(int page,int limit,int delFlag);

    /**
     * Select all major name ddms result.
     * 查询所有专业名称
     *
     * @return the ddms result
     */
    List<Major> selectAllMajorName();

    /**
     * Select time by major id ddms result.
     * 根据专业编号查询学制
     *
     * @param majorId the major id
     * @return the ddms result
     */
    DdmsResult selectTimeByMajorId(String majorId);

    /**
     * Insert one student ddms result.
     * 插入一条学生信息
     *
     * @param student the student
     * @return the ddms result
     */
    DdmsResult insertOneStudent(Student student);

    /**
     * Select one student ddms result.
     * 查询单条学生信息
     *
     * @param id the id  学生学号
     * @return the ddms result
     */
    DdmsResult selectOneStudent(String id);

    /**
     * Update one student ddms result.
     * 更新学生信息
     *
     * @param student the student  学生POJO对象
     * @return the ddms result
     */
    DdmsResult updateOneStudent(Student student);

    /**
     * Filter student list page result.
     * 筛选学生信息
     *
     * @param stuId    the stu id  学生ID
     * @param stuName  the stu name  学生姓名
     * @param stuMajor the stu major  学生专业
     * @param delFlag  the del flag  是否删除标记
     * @param page     the page  当前页数
     * @param limit    the limit  每页数量
     * @return the page result
     */
    PageResult filterStudentList(String stuId,String stuName,String stuMajor,int delFlag,int page,int limit);

    /**
     * Delete student first ddms result.
     * 第一次删除学生
     *
     * @param id      the id
     * @param delFlag the del flag
     * @return the ddms result
     */
    DdmsResult deleteStudentFirst(String id,int delFlag);

    /**
     * Select major id by major name string.
     * 根据专业名称查询专业ID
     *
     * @param majorName the major name  专业名称
     * @return the string
     */
    String selectMajorNameByMajorId(String majorName);

    /**
     * Delete student second ddms result.
     * 从数据库删除学生信息
     *
     * @param id the id  学生ID
     * @return the ddms result
     */
    DdmsResult deleteStudentSecond(String id);

    /**
     * Restore student ddms result.
     * 学生数据恢复
     *
     * @param id the id  学生ID
     * @return the ddms result
     */
    DdmsResult restoreStudent(String[] id);

    /**
     * Select student by ids list.
     * 根据ID数组查询多个学生
     *
     * @param id the id  学生ID数组
     * @return the list
     */
    List<Student> selectStudentByIds(String[] id);

    /**
     * Insert export list ddms result.
     * 导入Excel
     *
     * @param list the list
     * @return the ddms result
     */
    DdmsResult insertExportList(List<List<Object>> list);
}
