package com.wsh.dao;

import com.wsh.domain.Student;
import com.wsh.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wsh on 2017/12/14.
 * Student数据访问层实现类
 *
 * @version 1.0
 */
public class StudentDaoImpl implements StudentDao {

    public List<Student> query() {
        List<Student> students = new ArrayList<Student>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.prepareStatement("select * from student");
            resultSet = statement.executeQuery();
            Student student;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(resultSet, statement, connection);
        }
        return students;
    }

    public void save(Student student) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.prepareStatement("insert into student(name,age) values (?,?)");
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(resultSet, statement, connection);
        }
    }
}
