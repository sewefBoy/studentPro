package cn.ylcto.student.dao;

import cn.ylcto.student.dao.IDAO;
import cn.ylcto.student.vo.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by sewef on 2017/8/14.
 */
public interface IStudentDao extends IDAO<String,Student>{

    public List<Student> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException;

    public Integer getAllCount() throws SQLException;

    public boolean insertByBatch(List<Student> students) throws SQLException;
}
