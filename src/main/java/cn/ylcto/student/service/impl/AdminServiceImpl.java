package cn.ylcto.student.service.impl;

import cn.ylcto.student.dao.IAdminDAO;
import cn.ylcto.student.service.IAdminService;
import cn.ylcto.student.vo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by sewef on 2017/8/8.
 */
@Service
public class AdminServiceImpl implements IAdminService{

    @Autowired
    IAdminDAO adminDAO;
    public Admin findLogin(Admin vo) throws SQLException {
        Admin admin = adminDAO.findLogin(vo);
        if (admin != null){
            //vo.setLastdate(new java.util.Date());
            //this.adminDAO.doUpdate(vo);
        }
        return admin;
    }
}
