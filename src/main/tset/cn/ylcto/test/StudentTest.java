package cn.ylcto.test;

import cn.ylcto.student.service.IStudentService;
import cn.ylcto.student.vo.Classes;
import cn.ylcto.student.vo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
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

    @Test
    public void updateStudent() throws SQLException {
        Student student = new Student();
        student.setSid("xs001");
        student.setAddress("北京1");
        student.setAge(111);
        Classes classes = new Classes();
        classes.setCid(11);
        student.setClasses(classes);
        student.setName("李磊1111");
        student.setSex(1);
        studentService.updateStudent(student);
    }

    @Test
    public void insertByBatch() throws SQLException {
        List<Student> students = new ArrayList<Student>();
        Student student = new Student();
        student.setSid("xs010");
        student.setAddress("北京2");
        student.setAge(15);
        Classes classes = new Classes();
        classes.setCid(11);
        student.setClasses(classes);
        student.setName("张磊1");
        student.setSex(1);

        Student student1 = new Student();
        student1.setSid("xs011");
        student1.setAddress("北京3");
        student1.setAge(15);
        student1.setClasses(classes);
        student1.setName("张磊2");
        student1.setSex(1);

        Student student3 = new Student();
        student3.setSid("xs012");
        student3.setAddress("北京3");
        student3.setAge(15);
        student3.setClasses(classes);
        student3.setName("张磊3");
        student3.setSex(1);

        students.add(student);
        students.add(student1);
        students.add(student3);
        studentService.insertByBatch(students);
    }
}
