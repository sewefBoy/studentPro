package cn.ylcto.test;

import cn.ylcto.student.service.IAdminService;
import cn.ylcto.student.vo.Admin;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * Created by sewef on 2017/8/8.
 */
public class AdminServiceTest {

    @Resource
    private static ApplicationContext ctx;
    private static IAdminService adminService;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        adminService = ctx.getBean("adminServiceImpl",IAdminService.class);
    }
    @Test
    public void login(){
        Admin admin = new Admin();
        admin.setEmail("1224865593@qq.com");
        admin.setPassword("123456");

        try {
            Admin vo = adminService.findLogin(admin);
            System.out.print(vo.getLastdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
