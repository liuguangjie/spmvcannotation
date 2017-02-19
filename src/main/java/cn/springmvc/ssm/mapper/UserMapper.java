package cn.springmvc.ssm.mapper;


import cn.springmvc.ssm.domain.User;

/**
 * Created by free on 17-2-16.
 */
public interface UserMapper {

    public User findUserById(int userId) throws Exception;

    /*public void updateUser(User user) throws  Exception;

    public void deleteUserByid(int userId) throws Exception;

    public List<User> queryUserListBuName(String userName)throws Exception;

    public int findUserCount(QueryVo queryVo) throws Exception ;

    public List<User> findUserResultMap(QueryVo queryVo) throws Exception;*/

}
