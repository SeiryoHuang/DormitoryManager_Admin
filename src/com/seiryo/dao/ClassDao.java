package com.seiryo.dao;

import com.seiryo.po.Admin;
import com.seiryo.po.Clazz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassDao {
    public Integer totalCount(@Param("c_classname") String c_classname,@Param("c_id") Integer c_id);
    //获取用户列表
    public List<Clazz> getClassList(@Param("c_classname") String c_classname, @Param("c_classid") String c_classid, @Param("c_counsellor") String c_counsellor, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);
    public List<Clazz> findClassByNI(@Param("c_classname") String c_classname, @Param("c_classid") String c_classid);

    public int addClass(Clazz clazz);    //添加管理员信息
    public int deleteClass(Integer c_id);   //删除管理员信息
    public int updateClass(Clazz clazz); //修改管理员信息
    public Clazz findClassById(Integer c_id);
    public List<Clazz> getAll();
}
