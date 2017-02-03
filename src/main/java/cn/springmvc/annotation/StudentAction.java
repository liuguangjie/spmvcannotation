package cn.springmvc.annotation;

import cn.springmvc.bean.Student;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by free on 17-2-3.
 */
@Controller
public class StudentAction  {


    @RequestMapping("/editstudent")
    public String editstudent(Model model){
        Student student=new Student();
        student.setAge(22);
        student.setName("刘光杰");
        student.setBirthday(new Date());
        model.addAttribute("student",student);
        return "edit";
    }


    @RequestMapping("/savestudent")
    public String savestudent(Student student){

        System.out.println(student);
        return "hello";
    }

    //注册日期转换器
    @InitBinder
    public void registerDate(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }

}
