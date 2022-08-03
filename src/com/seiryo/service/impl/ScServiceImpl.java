package com.seiryo.service.impl;

import com.seiryo.dao.ScDao;
import com.seiryo.po.Clazz;
import com.seiryo.po.Student;
import com.seiryo.service.ScService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ScService")
@Transactional
public class ScServiceImpl implements ScService {
    @Autowired
    ScDao scDao;
    @Override
    public List<Student> findStudentByclass(String c_classid) {
        return scDao.findStudentByclass(c_classid);
    }
}
