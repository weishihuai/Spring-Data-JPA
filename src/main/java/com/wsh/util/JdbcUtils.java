package com.wsh.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by wsh on 2017/12/14.
 * 传统jdbc工具类
 *
 * @version 1.0
 */
public class JdbcUtils {

    /**
     * 获取链接对象
     *
     * @return Connection对象
     */
    public static Connection getConnection() {
        Connection connection = null;
        //不推荐使用硬编码操作，一般放在配置文件中
//        String driverClass = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql:///springdata";
//        String username = "root";
//        String password = "root";

        String driverClass;
        String url;
        String username;
        String password;

        InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            driverClass = properties.getProperty("jdbc.driverClass");
            url = properties.getProperty("jdbc.url");
            username = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }


    /**
     * 释放资源
     *
     * @param resultSet  结果集
     * @param statement  stmt
     * @param connection 连接对象
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
