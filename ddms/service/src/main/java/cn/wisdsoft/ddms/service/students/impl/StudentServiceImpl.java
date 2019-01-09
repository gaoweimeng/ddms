package cn.wisdsoft.ddms.service.students.impl;

import cn.wisdsoft.ddms.mapper.major.MajorMapper;
import cn.wisdsoft.ddms.mapper.student.StudentMapper;
import cn.wisdsoft.ddms.pojo.Major;
import cn.wisdsoft.ddms.pojo.Student;
import cn.wisdsoft.ddms.service.students.StudentService;
import cn.wisdsoft.pojo.DdmsResult;
import cn.wisdsoft.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：高伟萌
 * @ Date       ：Created in 2018/9/20 13:09
 * @ Description：学生业务层实现类
 * @ Modified By：
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public PageResult selectAllStudent(int page, int limit, int delFlag) {
        List<Student> students = studentMapper.selectAllStudent(page, limit, delFlag);
        int count = studentMapper.selectCounts(delFlag);
        return PageResult.ok(students, count);
    }

    @Override
    public List<Major> selectAllMajorName() {
        return majorMapper.selectAllName();
    }

    @Override
    public DdmsResult selectTimeByMajorId(String majorId) {
        return DdmsResult.ok(majorMapper.selectTimeByMajorId(majorId));
    }

    @Override
    public DdmsResult insertOneStudent(Student student) {
        int result = studentMapper.insert(student);
        return DdmsResult.ok(result);
    }

    @Override
    public DdmsResult selectOneStudent(String id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        String stuMajorid = student.getStuMajorId();
        String name = majorMapper.selectMajorNameByMajorId(stuMajorid);
        student.setMajorName(name);
        return DdmsResult.ok(student);
    }

    @Override
    public DdmsResult updateOneStudent(Student student) {
        int result = studentMapper.updateByPrimaryKey(student);
        return DdmsResult.ok(result);
    }

    @Override
    public PageResult filterStudentList(String stuId, String stuName, String stuMajor, int delFlag, int page, int limit) {
        List<Student> students = studentMapper.filterStudentList(stuId, stuName, stuMajor, delFlag, page, limit);
        int counts = studentMapper.filterCounts(stuId, stuName, stuMajor, delFlag);
        return PageResult.ok(students, counts);
    }

    @Override
    public DdmsResult deleteStudentFirst(String id, int delFlag) {
        int result = studentMapper.updateStudentDelFlag(id, delFlag);
        return DdmsResult.ok(result);
    }

    @Override
    public String selectMajorNameByMajorId(String majorName) {
        return majorMapper.selectMajorIdByMajorName(majorName);
    }

    @Override
    public DdmsResult deleteStudentSecond(String id) {
        int result = studentMapper.deleteByPrimaryKey(id);
        return DdmsResult.ok(result);
    }

    @Override
    public DdmsResult restoreStudent(String[] id) {
        return DdmsResult.ok(studentMapper.restoreStudent(id));
    }

    @Override
    public List<Student> selectStudentByIds(String[] id) {
        return studentMapper.selectStudentByIds(id);
    }

    @Override
    public DdmsResult insertExportList(List<List<Object>> list) {
        int result = studentMapper.insertExcelList(list);
        return DdmsResult.ok(result);
    }
}
