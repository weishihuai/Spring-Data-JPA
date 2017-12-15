package com.wsh.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by wsh on 2017/12/14.
 *
 * @version 1.0
 */
public class JdbcUtilsTest {
//    @Test
//    public void getConnection() throws Exception {
//        Connection connection = JdbcUtils.getConnection();
//        Assert.assertNotNull(connection);
//    }

    private ApplicationContext applicationContext = null;

    @Test
    public void test() {
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        Assert.assertNotNull(dataSource);

        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        Assert.assertNotNull(jdbcTemplate);

    }

    @Before
    public void setup() {
        applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    }

    @After
    public void after() {
        applicationContext = null;
    }

}