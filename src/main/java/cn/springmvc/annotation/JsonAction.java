package cn.springmvc.annotation;

import cn.springmvc.bean.ResultList;
import cn.springmvc.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by free on 17-2-10.
 */
@Controller
@RequestMapping("/json")
public class JsonAction {

    /**
     curl  -H "Content-Type:application/json;charset=UTF-8" -X POST -d '{"id":12,"name":"历史","age":21,"birthday":"2017-02-10"}' \
     http://127.0.0.1:8080/api/json/request

     curl  -H "Content-Type:application/xml;charset=UTF-8" -X POST -d '<?xml version="1.0" encoding="UTF-8"?><student-info><id>23</id><age>11</age><name>haha</name></student-info>' \
     http://127.0.0.1:8080/api/json/request

     * @param student
     * @return
     */

    @RequestMapping("/request")
    @ResponseBody
    public ResultList requestJson(@RequestBody Student student){
        ResultList resultList=new ResultList();
        List<Student> list=new ArrayList<Student>(1);
        list.add(student);
        resultList.setData(list);
        resultList.setCode("00000");
        resultList.setMessage("success");
        //System.out.println(stu);
        System.out.println(student);
        return resultList;
    }
}
