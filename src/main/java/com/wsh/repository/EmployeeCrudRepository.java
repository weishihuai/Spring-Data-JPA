package com.wsh.repository;

import com.wsh.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wsh on 2017/12/15.
 * CrudRepository 简单增删查改
 * 继承自Repository
 * @version 1.0
 */
public interface EmployeeCrudRepository extends CrudRepository<Employee,Integer> {



}
