package cn.springmvc.annotation;

import cn.springmvc.bean.ResultList;
import cn.springmvc.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by free on 17-2-10.
 */
@Controller
@RequestMapping("/json")
public class JsonAction {

    /**
     请求json 和返回json
     curl  -H "Content-Type:application/json;charset=UTF-8" -H "Accept:application/json;charset=UTF-8" \
     -X POST -d '{"id":12,"name":"历史","age":21,"birthday":"2017-02-10"}'  http://127.0.0.1:8080/api/json/request

     请求xml 和返回xml
     1 castor 方式
     curl -H "Accept:application/xml" -H "Content-Type:application/xml;charset=UTF-8" -X POST -d '<?xml version="1.0" encoding="UTF-8"?><student-info><id>23</id><age>11</age><name>haha</name></student-info>' \
     http://127.0.0.1:8080/api/json/request

     2.XStream 方式
     curl -H "Accept:application/xml" -H "Content-Type:application/xml;charset=UTF-8" -X POST -d \
     '<?xml version="1.0" ?><cn.springmvc.bean.Student><id>1</id><age>33</age><name>ss</name><birthday>2017-02-25 20:23:19</birthday></cn.springmvc.bean.Student>' \
     http://127.0.0.1:8080/api/json/request

     巧妙运用国际化

     * @param student
     * @return
     */

    @RequestMapping("/request")
    @ResponseBody
    public ResultList requestJson(@RequestBody Student student, HttpServletRequest request){
        ResultList resultList=new ResultList();
        System.out.println(request.getLocale().getLanguage());
        resultList.setLocale(request.getLocale());
        List<Student> list=new ArrayList<Student>(1);
        list.add(student);
        Student st=new Student();
        st.setAge(55);
        st.setName("jiji");
        st.setId(33);
        list.add(st);
        resultList.setData(list);
        resultList.setCode("00003");
        //System.out.println(stu);
        System.out.println(student);
        return resultList;
    }
}
