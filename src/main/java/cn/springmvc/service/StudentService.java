package cn.springmvc.service;

import cn.springmvc.bean.Student;
import cn.springmvc.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by free on 17-2-7.
 */
@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public List<Student> getStudents(){

        return studentDao.getStudentList();
    }

    public Student getStudentById(Integer id) {

        return  studentDao.getStudentById(id);
    }

    public void updatestudent(Student student) {
        studentDao.updatestudent(student);
    }
}
