package cn.springmvc.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by free on 17-2-12.
 */
@Controller
public class Index {

    @RequestMapping("/")
    public String index(Model model) throws Exception {
        List<String> datas=new ArrayList<String>();
        datas.add("C++");
        datas.add("java");
        datas.add("C");
        datas.add("pythen");
        datas.add("linux");
        datas.add("shell");
        datas.add("ruby");
        model.addAttribute("datas",datas);

        List list = new ArrayList();
        Map map1 = new HashMap();
        map1.put("phone", "13655555555");
        map1.put("email", "admin@vip.com");
        list.add(map1);
        Map map2 = new HashMap();
        map2.put("phone", "13888888888");
        map2.put("email", "china@vip.com");
        map2.put("address", "beijing");
        list.add(map2);
        model.addAttribute("list",list);
        try {
            int i=1/0;
        }catch (ArithmeticException a){
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("index");
            modelAndView.addObject("message",a.getMessage());
            throw  new ModelAndViewDefiningException(modelAndView);
        }
        return "index";
    }
}
