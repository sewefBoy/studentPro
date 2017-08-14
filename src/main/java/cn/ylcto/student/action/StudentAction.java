package cn.ylcto.student.action;

import cn.ylcto.student.service.IStudentService;
import cn.ylcto.student.vo.Student;
import cn.ylcto.util.action.DefaultAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by sewef on 2017/8/14.
 */
@Controller
@RequestMapping(value = "/pages/back/student/*")
public class StudentAction extends DefaultAction {
    @Resource
    IStudentService studentService;

    @RequestMapping(value = "student_insert")
    public ModelAndView insertStu(Student student) throws Exception{
        ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
        if(studentService.insertStu(student)){
            super.setMsgAndPath(mav,"student.insert.success","page.student.insert.success");
        }
        else{
            super.setMsgAndPath(mav,"student.insert.fail","page.student.insert.fail");
        }
        return mav;
    }







    @Override
    public String getText() {
        return null;
    }
}
