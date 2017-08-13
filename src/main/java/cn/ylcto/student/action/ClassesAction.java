package cn.ylcto.student.action;

import cn.ylcto.student.service.IClassesService;
import cn.ylcto.student.vo.Classes;
import cn.ylcto.util.action.DefaultAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by sewef on 2017/8/13.
 */
@Controller
@RequestMapping(value = "/pages/back/classes/*")
public class ClassesAction extends DefaultAction{
    @Resource
    IClassesService classesService;

    @RequestMapping(value = "classes_insert")
    public ModelAndView insert(Classes classesVo) throws Exception{
        ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));

        if(classesService.insert(classesVo)){
            super.setMsgAndPath(mav,"classes.insert.success","classes.login.success");
        }
        else{
            super.setMsgAndPath(mav,"classes.insert.fail","classes.login.fail");
        }
        return mav;
    }

    @Override
    public String getText() {
        return "班级";
    }
}
