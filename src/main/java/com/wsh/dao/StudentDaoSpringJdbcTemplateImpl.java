package com.wsh.dao;

import com.wsh.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wsh on 2017/12/14.
 * Spring jdbcTemplate 方式
 *
 * @version 1.0
 */
public class StudentDaoSpringJdbcTemplateImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> query() {
        final List<Student> studentList = new ArrayList<Student>();
        String sql = "select * from student";

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                studentList.add(student);
            }
        });
        return studentList;
    }

    public void save(Student student) {
        String sql = "insert into student(name,age) values (?,?)";
        jdbcTemplate.update(sql,new Object[]{student.getName(),student.getAge()});
    }
}
