package cn.ylcto.test;

import cn.ylcto.student.service.IStudentService;
import cn.ylcto.student.vo.Classes;
import cn.ylcto.student.vo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    @Test
    public void findAllBySplit(){
        try {
            Map<String,Object> map = studentService.findAllBySplit(1,2);
//            for (Student s : list){
//                System.out.println(s.getName());
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
