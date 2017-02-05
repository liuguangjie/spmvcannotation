package cn.springmvc.annotation;

import cn.springmvc.bean.Student;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by free on 17-2-3.
 */
@Controller
public class StudentAction  {


    @RequestMapping("/editstudent")
    public String editstudent(Model model, HttpServletRequest request, HttpServletResponse response){
        Student student=new Student();
        student.setAge(22);
        student.setName("刘光杰");
        student.setBirthday(new Date());
        model.addAttribute("student",student);
        System.out.println("查询的uri="+request.getRequestURI());
        System.out.println(getDescription(request.getAttributeNames(),request));
        return "edit";
    }

    public String getDescription(Enumeration<?> stringEnumeration,HttpServletRequest request){
        StringBuilder sb = new StringBuilder();
        while (stringEnumeration !=null && stringEnumeration.hasMoreElements()){
            String name=(String)stringEnumeration.nextElement();
            sb.append(name+"="+request.getAttribute(name)+" \n ");
        }
        return sb.toString();

    }


    @RequestMapping("/savestudent")
    public String savestudent(Student student){
        System.out.println("学生信息 = "+student);
        System.out.println("map 的值...");
        /*for (Map.Entry<String,Object> hashEntry:params.entrySet()){
            System.out.print(hashEntry.getKey()+"="+hashEntry.getValue()+"\t");
        }*/


        return "hello";
    }

    //注册日期转换器
    @InitBinder
    public void registerDate(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }

}
