package cn.ylcto.student.service;

import cn.ylcto.student.vo.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by sewef on 2017/8/14.
 */
public interface IStudentService {
    public boolean insertStu(Student vo) throws SQLException;

    //分页
    public Map<String, Object> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException;
    //查询总条数
    public Integer getAllCount() throws SQLException;

    public boolean updateStudent(Student vo) throws SQLException;

    //批量插入
    public boolean insertByBatch(List<Student> students) throws SQLException;
}
