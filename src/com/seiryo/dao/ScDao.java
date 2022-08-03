package com.seiryo.dao;

import com.seiryo.po.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScDao {
    public List<Student> findStudentByclass(@Param("c_classid") String c_classid);
}
