package com.seiryo.dao;

import com.seiryo.po.DormGrade;
import com.seiryo.po.PageInfo;
import com.seiryo.po.Stgrade;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StudentGradeDao {
    public PageInfo<Stgrade> findPageInfo(Integer g_id, Integer s_studentid, String s_name, Integer s_grade, Integer s_classid,
                                          Integer s_dormitoryid, Date create_time, Date update_time,
                                          Integer pageIndex, Integer pageSize);

    public int addStudentClean (Stgrade stgrade);

    public int deleteStudentClean(Integer g_id);

    public int updateStudentClean(Stgrade stgrade);

    public Stgrade findStudentCleanById(Integer g_id);

    public List<Stgrade> getAll();

    public Integer totalCount(@Param("g_id") Integer g_id, @Param("s_studentid") Integer s_studentid,@Param("s_name")String s_name, @Param("s_grade")Integer s_grade, @Param("s_classid")Integer s_classid,
                              @Param("s_dormitoryid")Integer s_dormitoryid, @Param("create_time")Date create_time, @Param("update_time")Date update_time);

    public List<Stgrade> getStudentGradeList(@Param("g_id") Integer g_id, @Param("s_studentid") Integer s_studentid,@Param("s_name")String s_name, @Param("s_grade")Integer s_grade, @Param("s_classid")Integer s_classid,
                                             @Param("s_dormitoryid")Integer s_dormitoryid, @Param("create_time")Date create_time, @Param("update_time")Date update_time,
                                            @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);
}
