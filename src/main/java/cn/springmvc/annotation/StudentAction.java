package cn.springmvc.annotation;

import cn.springmvc.bean.Student;
import cn.springmvc.service.StudentService;
import cn.springmvc.wrap.StudentSrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by free on 17-2-3.
 */
@Controller
@RequestMapping("/stu")
public final class StudentAction {

    @Autowired
    private StudentService service;

    @Autowired
    private HttpServletRequest servletRequest;

    @RequestMapping(value = "/querystudentlist", method = {RequestMethod.GET})
    public String queryStudens(Model model) {
        List<Student> list = service.getStudents();
        model.addAttribute("list", list);
        servletRequest.setAttribute("xxxx","ddddd");
        System.out.println(servletRequest.getSession(true).getId());
        return "studentlist";
    }

    @Token(save = true)
    @RequestMapping(value = "/editstudent/{id}", method = {RequestMethod.GET})
    public String editstudent(Model model, @PathVariable("id") Integer id) {
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "edit";
    }

    @RequestMapping(value = "/getlist", method = {RequestMethod.GET,RequestMethod.POST})
    public String getlist(StudentSrap studentSrap) {
        System.out.println(studentSrap.getStudentList());
        return "forward:/api/stu/queryId";
    }

    @RequestMapping(value = "/queryId", method = {RequestMethod.GET,RequestMethod.POST})
    public String queryId(String queryId,StudentSrap studentSrap) {
        System.out.println(queryId+"  queryId");
        System.out.println(studentSrap.getStudentList());
        return "hello";
    }

    public String getDescription(Enumeration<?> stringEnumeration, HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        while (stringEnumeration != null && stringEnumeration.hasMoreElements()) {
            String name = (String) stringEnumeration.nextElement();
            sb.append(name + "=" + request.getAttribute(name) + " \n ");
        }
        return sb.toString();

    }

    @Token(save = true)
    @RequestMapping("/updatestudent")
    public String updatestudent(Student student, Model model,StudentSrap studentSrap) {
        service.updatestudent(studentSrap.getStudent());
        System.out.println(student);
        model.addAttribute("message", " secceses");
        return "hello";
    }

    //注册日期转换器
    @InitBinder
    public void registerDate(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
        System.out.println("执行 registerDate方法" + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
    }

}
