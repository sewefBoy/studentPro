package cn.ylcto.student.dao;

import cn.ylcto.student.vo.Classes;

import java.util.List;

/**
 * Created by sewef on 2017/8/13.
 */
public interface IClassesDao extends IDAO<String,Classes> {
    public Classes findByCname(String cname) throws Exception;

    public boolean deleteClasses(List<Integer> cids) throws Exception;
}
