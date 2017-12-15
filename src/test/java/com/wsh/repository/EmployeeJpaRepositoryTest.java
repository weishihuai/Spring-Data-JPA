package com.wsh.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wsh on 2017/12/15.
 *
 * @version 1.0
 */
public class EmployeeJpaRepositoryTest {

    @Test
    public void find() throws Exception {
        System.out.println(employeeJpaRepository.findOne(1));
        System.out.println(employeeJpaRepository.exists(2));  //存在就是true
        System.out.println(employeeJpaRepository.exists(20)); // 不存在就是false
    }


    private ApplicationContext ctx = null;
    private EmployeeJpaRepository employeeJpaRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaRepository = ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

}