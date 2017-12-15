package com.wsh.dao;

import com.wsh.domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wsh on 2017/12/14.
 *
 * @version 1.0
 */
public class StudentDaoSpringJdbcTemplateImplTest {
    @Test
    public void save() throws Exception {
        Student student = new Student();
        student.setName("tianqi");
        student.setAge(43);
        StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDaoSpringJdbc");
        studentDao.save(student);
    }

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void query() throws Exception {
        StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDaoSpringJdbc");
        for (Student student : studentDao.query()) {
            System.out.println(student);
        }
    }

}