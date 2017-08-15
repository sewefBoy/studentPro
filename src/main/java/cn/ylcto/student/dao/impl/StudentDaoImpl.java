package cn.ylcto.student.dao.impl;

import cn.ylcto.student.dao.IStudentDao;
import cn.ylcto.student.vo.Student;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sewef on 2017/8/14.
 */
@Repository
public class StudentDaoImpl extends SqlSessionDaoSupport implements IStudentDao{
    @Autowired
    public StudentDaoImpl(SqlSessionFactory sqlSessionFactory){super.setSqlSessionFactory(sqlSessionFactory);}

    @Override
    public boolean doCreate(Student vo) throws SQLException {
        return super.getSqlSession().insert("StudentNS.doCreate",vo) > 0;
    }

    @Override
    public boolean doUpdate(Student vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Student findById(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Student> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Student> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public List<Student> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("start",(currentPage-1)*lineSize); // 表表示当前页
        map.put("lineSize",lineSize); // 表表示当前页
        return super.getSqlSession().selectList("StudentNS.findAllBySplit", map);
    }

    @Override
    public Integer getAllCount() throws SQLException {
        return super.getSqlSession().selectOne("StudentNS.getAllCount");
    }
}
