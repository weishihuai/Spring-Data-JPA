package com.wsh.dao;

import com.wsh.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * Created by wsh on 2017/12/14.
 *
 * @version 1.0
 */
public class StudentDaoImplTest {
    @Test
    public void save() throws Exception {
        Student student = new Student();
        student.setName("zhaoliu");
        student.setAge(42);
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.save(student);
    }

    @Test
    public void query() throws Exception {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> studentList = studentDao.query();
        if (studentList.size() > 0) {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

}