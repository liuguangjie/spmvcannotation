package cn.springmvc.wrap;

import cn.springmvc.bean.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by free on 17-2-10.
 */
public class StudentSrap {


    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    private List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    private Map<String,Student>  studentMap;

    public Map<String, Student> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<String, Student> studentMap) {
        this.studentMap = studentMap;
    }


}
