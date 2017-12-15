package com.wsh.repository;

import com.wsh.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository { //extends Repository<Employee,Integer>{

    Employee findByName(String name);

    //sql:  where name like ?% and age <?
    List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    //sql:  where name like %? and age <?
    List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    //sql:  where name in (?,?....) or age <?
    List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer age);

    //sql:  where name in (?,?....) and age <?
    List<Employee> findByNameInAndAgeLessThan(List<String> names, Integer age);

    // where age between age1 and age2
    List<Employee> findByAgeBetween(Integer age1, Integer age2);

    @Query("select o from Employee o where id=(select max(id) from Employee t1)")
    Employee getEmployeeByMaxId();

    //占位符方式  不需要使用@Param
    @Query("select o from Employee o where o.name=?1 and o.age=?2")
    List<Employee> queryParams1(String name, Integer age);

    //参数方式  需要使用@Param  :name  对应参数的value  @Param(value="name")
    @Query("select o from Employee o where o.name=:name and o.age=:age")
    List<Employee> queryParams2(@Param("name") String name, @Param("age") Integer age);

    //占位符方式
    @Query("select o from Employee o where o.name like %?1%")
    List<Employee> queryLike1(String name);

    //参数方式  :name  对应参数的value  @Param(value="name")
    @Query("select o from Employee o where o.name like %:name%")
    List<Employee> queryLike2(@Param("name") String name);

    //本地查询 使用sql查询  from employee 对应数据库表名 需要加上nativeQuery = true
    @Query(nativeQuery = true, value = "select count(1) from employee")
    long getCount();

    //更新操作 需要加上事务控制
    @Modifying
    @Query("update Employee o set o.age = :age where o.id = :id")
    void update(@Param("id") Integer id, @Param("age") Integer age);


}
