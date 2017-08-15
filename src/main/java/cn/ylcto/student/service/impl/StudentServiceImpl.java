package cn.ylcto.student.service.impl;

import cn.ylcto.student.dao.IStudentDao;
import cn.ylcto.student.service.IStudentService;
import cn.ylcto.student.vo.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sewef on 2017/8/14.
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Resource
    IStudentDao studentDao;
    @Override
    public boolean insertStu(Student vo) throws SQLException {
        return studentDao.doCreate(vo);
    }

    @Override
    public Map<String, Object> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
        Map<String,Object> map  = new HashMap<>();
        map.put("allStudent",this.studentDao.findAllBySplit(currentPage,lineSize));
        map.put("studentCount",this.studentDao.getAllCount());
        return map;
    }

    @Override
    public Integer getAllCount() throws SQLException {
        return studentDao.getAllCount();
    }
}
