package cn.ylcto.student.action;

import cn.ylcto.student.service.IStudentService;
import cn.ylcto.student.vo.Student;
import cn.ylcto.util.action.DefaultAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "student_list")
    public void list(HttpServletRequest request, HttpServletResponse response){
        super.handSplit(request,response);
        try {
            Map<String,Object> map = this.studentService.findAllBySplit(super.getCurrentPage(),super.getLineSize());
            List<Student> all = (List<Student>) map.get("allStudent");
            Integer allRecorders = (Integer) map.get("studentCount");
            super.printObjectToListSplit(response,"allStudent",all,allRecorders);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    @Override
    public String getText() {
        return null;
    }
}
