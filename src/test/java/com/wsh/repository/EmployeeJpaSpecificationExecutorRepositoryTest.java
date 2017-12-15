package com.wsh.repository;

import com.wsh.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * Created by wsh on 2017/12/15.
 *
 * @version 1.0
 */
public class EmployeeJpaSpecificationExecutorRepositoryTest {

    @Test
    public void test() throws Exception {
        //排序  ：   id  降序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);

        //page: 页数（从0开始,不是从1开始）
        //size: 每页显示记录数
        Pageable pageable = new PageRequest(0, 5, sort);

        Specification<Employee> specification = new Specification<Employee>() {
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                // root (employee(age))
                Path path = root.get("age");
                return cb.gt(path,10);
            }
        };

        Page<Employee> page = employeeJpaSpecificationExecutorRepository.findAll(specification,pageable);
        System.out.println("总页数===>" + page.getTotalPages()); //总页数
        System.out.println("总记录数===>" + page.getTotalElements()); //总记录数
        System.out.println("当前页面的数据集合===>" + page.getContent()); //当前页面的数据集合
        System.out.println("当前第几页===>" + (page.getNumber() + 1) ); //当前第几页
        System.out.println("当前页面的记录数===>" + page.getNumberOfElements());  //当前页面的记录数
    }


    private ApplicationContext ctx = null;
    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaSpecificationExecutorRepository = ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

}