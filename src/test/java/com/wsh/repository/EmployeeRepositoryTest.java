package com.wsh.repository;


import com.wsh.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryTest {
    @Test
    public void findByAgeBetween() throws Exception {
        List<Employee> employees = employeeRepository.findByAgeBetween(1,40);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }


    private ApplicationContext ctx = null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testFindByName() {
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println(employee);
    }

    @Test
    public void testFindByNameStartingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("z", 42);

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testFindByNameEndingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("6", 23);

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }


    @Test
    public void testFindByNameInOrAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names, 22);

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testFindByNameInAndAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInAndAgeLessThan(names, 22);

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testGetEmployeeByMaxId() {
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println(employee);
    }

    @Test
    public void testQueryParams1() {
        List<Employee> employees = employeeRepository.queryParams1("zhangsan", 20);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testQueryParams2() {
        List<Employee> employees = employeeRepository.queryParams2("zhangsan", 20);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }


    @Test
    public void testQueryLike1() {
        List<Employee> employees = employeeRepository.queryLike1("zh");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testQueryLike2() {
        List<Employee> employees = employeeRepository.queryLike2("zh");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testGetCount() {
        long count = employeeRepository.getCount();
        System.out.println("count:" + count);
    }


}
