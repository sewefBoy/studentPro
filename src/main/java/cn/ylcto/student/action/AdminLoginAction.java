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

    @RequestMapping(value = "admin_login")
    public ModelAndView login(HttpServletRequest request, Admin admin) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(super.getResource("pages.forward"));
        Admin adminVo = this.adminService.findLogin(admin);
        if(adminVo == null){
            super.setMsgAndPath(modelAndView,"admin.login.fail","page.admin.login.fail");
        }
        else{
            super.setMsgAndPath(modelAndView,"admin.login.SUCCESS","page.admin.login.success");
            request.getSession().setAttribute("email", adminVo.getEmail());
            request.getSession().setAttribute("lastdate",new SimpleDateFormat("yyyy-MM-dd").format(adminVo.getLastdate())); // 取得最后一次登录日期操作
        }
        return modelAndView;
    }

    public String getText() {
        return "管理员";
    }
}
