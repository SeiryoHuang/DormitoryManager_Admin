package com.seiryo.service;

import com.seiryo.po.Clazz;
import com.seiryo.po.Student;

import java.util.List;

public interface ScService {
    public List<Student> findStudentByclass(String c_classid );
}
