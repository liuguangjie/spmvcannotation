package cn.springmvc.ssm.dao;



import cn.springmvc.ssm.domain.User;

import java.util.List;

/**
 * Created by free on 17-2-16.
 */
public interface UserDao {

    public User findUserById(int userId) throws Exception;


}
