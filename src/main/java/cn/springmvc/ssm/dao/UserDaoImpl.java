package cn.springmvc.ssm.dao;


import cn.springmvc.ssm.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * Created by free on 17-2-16.
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {


    public User findUserById(int userId) throws Exception {
        SqlSession sqlSession=getSqlSession();
        User user=sqlSession.selectOne("test.findUserById",userId);
        return user;
    }

}
