package cn.springmvc.ssm.service;

import cn.springmvc.ssm.dao.UserDao;
import cn.springmvc.ssm.domain.User;
import cn.springmvc.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by free on 17-3-10.
 */
@Service
public class UserService {

    /*@Autowired
    private UserDao userDao;*/

    @Autowired
    private UserMapper userDao;


    public User findUserById(int userId) throws Exception{

        return userDao.findUserById(userId);
    }

}
