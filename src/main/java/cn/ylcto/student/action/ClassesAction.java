package cn.ylcto.student.action;

import cn.ylcto.student.service.IClassesService;
import cn.ylcto.student.vo.Classes;
import cn.ylcto.util.action.DefaultAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            super.setMsgAndPath(mav,"classes.insert.success","page.classes.insert.success");
        }
        else{
            super.setMsgAndPath(mav,"classes.insert.fail","page.classes.insert.fail");
        }
        return mav;
    }

    @RequestMapping(value="classes_list")
    public void findAll(HttpServletResponse response) throws Exception{
        try {
            super.printObjectToList(response,"allClasses",this.classesService.findAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value="classes_deleteClasses")
    public void deleteClasses(HttpServletResponse response,HttpServletRequest request) throws Exception{
        String result [] = request.getParameter("cids").split("\\|");
        List<Integer> all = new ArrayList<Integer>();
        for (int x = 0;x < result.length;x++){
            all.add(Integer.parseInt(result[x]));
        }
        if (all.size() > 0){
            super.print(response,this.classesService.deleteClasses(all));
        }else{
            super.print(response,"false"); // 删除数据不成功返回false
        }
    }

    @Override
    public String getText() {
        return "班级";
    }
}
