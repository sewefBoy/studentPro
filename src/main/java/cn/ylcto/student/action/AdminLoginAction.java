package cn.ylcto.student.action;

import cn.ylcto.student.service.IAdminService;
import cn.ylcto.student.vo.Admin;
import cn.ylcto.util.action.DefaultAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * Created by sewef on 2017/8/8.
 */
@Controller
@RequestMapping(value = "/pages/back/*")
public class AdminLoginAction extends DefaultAction{

    @Resource
    private IAdminService adminService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "admin_login")
    public ModelAndView login(Admin admin) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(super.getResource("pages.forward"));
        Admin adminVo = this.adminService.findLogin(admin);
        if(adminVo == null){
            super.setMsgAndPath(modelAndView,"admin.login.fail","admin.login.fail");
        }
        else{
            super.setMsgAndPath(modelAndView,"admin.login.SUCCESS","admin.login.success");
            request.getSession().setAttribute("email", adminVo.getEmail());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String lastdate = sdf.format(adminVo.getLastdate());
            request.getSession().setAttribute("lastdate", lastdate);
        }
        return modelAndView;
    }

    public String getText() {
        return "管理员";
    }
}
