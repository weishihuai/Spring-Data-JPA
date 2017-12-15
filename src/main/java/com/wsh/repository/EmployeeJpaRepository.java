package com.wsh.repository;

import com.wsh.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wsh on 2017/12/15.
 *
 * @version 1.0
 */
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {
}
