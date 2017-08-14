package cn.ylcto.student.service.impl;

import cn.ylcto.student.dao.IStudentDao;
import cn.ylcto.student.service.IStudentService;
import cn.ylcto.student.vo.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

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
}
