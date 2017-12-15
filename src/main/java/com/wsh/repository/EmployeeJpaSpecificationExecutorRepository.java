package com.wsh.repository;

import com.wsh.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by wsh on 2017/12/15.
 *
 * @version 1.0
 */
public interface EmployeeJpaSpecificationExecutorRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
}
