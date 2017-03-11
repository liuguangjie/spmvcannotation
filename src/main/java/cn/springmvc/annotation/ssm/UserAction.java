package cn.springmvc.annotation.ssm;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by free on 17-3-10.
 */
@Controller
@RequestMapping(value = "/user")
public class UserAction {

    /*@Autowired
    private UserService userService;*/

    @RequestMapping(value = "/test")
    public String testRequest() throws Exception {

        /*User user=userService.findUserById(1);
        System.out.println(user);*/
        return "index";
    }

}
