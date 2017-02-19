package cn.springmvc.test;

import cn.springmvc.ssm.dao.UserDao;
import cn.springmvc.ssm.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by free on 17-2-19.
 */
public class UserDaoImplTest {

    @Test
    public void findUserById() throws Exception {
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("ssm/spring-mybatis.xml");
        /*UserDao userDao=ac.getBean(UserDao.class);
        System.out.println(userDao.findUserById(1));*/
        UserMapper userMapper=ac.getBean(UserMapper.class);
        System.out.println(userMapper.findUserById(1));
        ac.close();
    }

}