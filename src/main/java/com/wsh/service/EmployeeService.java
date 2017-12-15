package com.wsh.service;

import com.wsh.domain.Employee;
import com.wsh.repository.EmployeeCrudRepository;
import com.wsh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void update(Integer id, Integer age) {
        employeeRepository.update(id, age);
    }

    @Transactional
    public void save(List<Employee> employees) {
        employeeCrudRepository.save(employees);
    }

}
