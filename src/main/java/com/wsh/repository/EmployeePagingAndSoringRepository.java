package com.wsh.repository;

import com.wsh.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wsh on 2017/12/15.
 * PagingAndSortingRepository 排序分页Repository
 * @version 1.0
 */
public interface EmployeePagingAndSoringRepository extends PagingAndSortingRepository<Employee,Integer> {



}
