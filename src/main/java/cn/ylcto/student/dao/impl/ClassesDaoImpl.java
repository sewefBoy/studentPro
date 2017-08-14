package cn.ylcto.student.dao.impl;

import cn.ylcto.student.dao.IClassesDao;
import cn.ylcto.student.vo.Classes;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * Created by sewef on 2017/8/13.
 */
@Repository
public class ClassesDaoImpl extends SqlSessionDaoSupport implements IClassesDao{
    @Autowired
    public ClassesDaoImpl(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public boolean doCreate(Classes vo) throws SQLException {
        return super.getSqlSession().insert("ClassesNS.doCreate", vo)>0;
    }

    @Override
    public boolean doUpdate(Classes vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Classes findById(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Classes> findAll() throws SQLException {
        List<Classes> classesList = super.getSqlSession().selectList("ClassesNS.findAll");
        return classesList;
    }

    @Override
    public List<Classes> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public Classes findByCname(String cname) throws Exception {
        return super.getSqlSession().selectOne("ClassesNS.findByCname",cname);
    }

    public boolean deleteClasses(List<Integer> cids) throws Exception{
        return super.getSqlSession().delete("ClassesNS.deleteClasses",cids)>0;
    }
}
