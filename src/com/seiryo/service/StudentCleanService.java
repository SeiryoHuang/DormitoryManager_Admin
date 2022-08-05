package com.seiryo.service;

import com.seiryo.po.PageInfo;
import com.seiryo.po.Stgrade;

import java.util.Date;
import java.util.List;

public interface StudentCleanService {

    public PageInfo<Stgrade> findPageInfo(Integer g_id, Integer s_studentid, String s_name, Integer s_grade, Integer s_classid,
                                          Integer s_dormitoryid, Date create_time, Date update_time,
                                          Integer pageIndex, Integer pageSize);

    public int addStudentClean (Stgrade stgrade);

    public int deleteStudentClean(Integer g_id);

    public int updateStudentClean(Stgrade stgrade);

    public Stgrade findStudentCleanById(Integer g_id);

    public List<Stgrade> getAll();
}
