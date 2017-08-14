package cn.ylcto.test;

import cn.ylcto.student.service.IStudentService;
import cn.ylcto.student.vo.Classes;
import cn.ylcto.student.vo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created by sewef on 2017/8/14.
 */
public class StudentTest {
    private static ApplicationContext ctx;
    private static IStudentService studentService;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService = ctx.getBean("studentServiceImpl",IStudentService.class);
    }

    @Test
    public void doCreate(){
        Student student = new Student();
        student.setAddress("北京");
        student.setAge(11);
        student.setClasses(new Classes());
        student.setName("李磊");
        student.setSex(1);
        student.setSid("11");

        try {
            studentService.insertStu(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
