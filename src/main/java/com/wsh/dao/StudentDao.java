package com.wsh.dao;

import com.wsh.domain.Student;

import java.util.List;

/**
 * Created by wsh on 2017/12/14.
 * Student数据访问层接口
 *
 * @version 1.0
 */
public interface StudentDao {

    /**
     * 查询学生列表
     *
     * @return
     */
    List<Student> query();

    /**
     * 保存学生信息
     *
     * @param student
     */
    void save(Student student);
}
