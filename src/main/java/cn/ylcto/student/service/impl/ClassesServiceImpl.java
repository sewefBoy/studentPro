package cn.ylcto.student.service.impl;

import cn.ylcto.student.dao.IClassesDao;
import cn.ylcto.student.service.IClassesService;
import cn.ylcto.student.vo.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sewef on 2017/8/13.
 */
@Service
public class ClassesServiceImpl implements IClassesService {
    @Resource
    IClassesDao classesDao;

    @Override
    public boolean insert(Classes vo) throws Exception {
        if(classesDao.findByCname(vo.getCname())==null){
            classesDao.doCreate(vo);
        }
        else{
            System.out.print("存在");
            throw new RuntimeException("名称已经存在");
        }
        return true;
    }

    @Override
    public List<Classes> findAll() throws Exception {
        List<Classes> classesList = classesDao.findAll();
        return classesList;
    }

    @Override
    public boolean deleteClasses(List<Integer> cids) throws Exception {
        return classesDao.deleteClasses(cids);
    }


}
