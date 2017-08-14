package cn.ylcto.student.service;

import cn.ylcto.student.vo.Classes;

import java.util.List;

/**
 * Created by sewef on 2017/8/13.
 */
public interface IClassesService {
    //增加
    public boolean insert(Classes vo) throws Exception;

    public List<Classes> findAll() throws Exception;

    public boolean deleteClasses(List<Integer> cids) throws Exception;
}
