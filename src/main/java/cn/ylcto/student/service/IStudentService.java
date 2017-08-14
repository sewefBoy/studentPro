package cn.ylcto.student.service;

import cn.ylcto.student.vo.Student;

import java.sql.SQLException;

/**
 * Created by sewef on 2017/8/14.
 */
public interface IStudentService {
    public boolean insertStu(Student vo) throws SQLException;
}
