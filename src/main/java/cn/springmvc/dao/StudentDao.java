package cn.springmvc.dao;

import cn.springmvc.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Date;
import java.util.List;

/**
 * Created by free on 17-2-7.
 */
@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Student> getStudentList(){
        return jdbcTemplate.query("select f_id as id ,f_name as name, f_age as age,f_birthday as birthday  from t_student",new BeanPropertyRowMapper<Student>(){
            @Override
            public Student mapRow(ResultSet rs, int rowNumber) throws SQLException {
                Student stu=new Student();
                int id=rs.getInt("id");
                String name =rs.getString("name");
                int age=rs.getInt("age");
                Date date=rs.getDate("birthday");
                stu.setId(id);
                stu.setAge(age);
                stu.setBirthday(date);
                stu.setName(name);
                return stu;
            }
        });
    }

    public Student getStudentById(Integer id) {

        return jdbcTemplate.queryForObject("select f_id as id ,f_name as name, f_age as age,f_birthday as birthday  from t_student where f_id=" +id ,new BeanPropertyRowMapper<Student>(){
            @Override
            public Student mapRow(ResultSet rs, int rowNumber) throws SQLException {
                Student stu=new Student();
                int id=rs.getInt("id");
                String name =rs.getString("name");
                int age=rs.getInt("age");
                Date date=rs.getDate("birthday");
                stu.setId(id);
                stu.setAge(age);
                stu.setBirthday(date);
                stu.setName(name);
                return stu;
            }
        });
    }

    public void updatestudent(final  Student student) {
        jdbcTemplate.update("update t_student set f_name=?,f_age=?,f_birthday=? where f_id=?", new PreparedStatementSetter(){
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,student.getName());
                ps.setInt(2,student.getAge());
                ps.setDate(3, new java.sql.Date(student.getBirthday().getTime()));
                ps.setInt(4,student.getId());
            }
        });
    }
}