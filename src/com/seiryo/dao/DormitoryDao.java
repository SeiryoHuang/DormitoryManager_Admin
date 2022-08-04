package com.seiryo.dao;
import com.seiryo.po.Admin;
import com.seiryo.po.Dormitory;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * 宿舍DAO层接口
 */
public interface DormitoryDao {
    
    public Dormitory findDormitory(Dormitory dormitory);

    /**
     * 进行分页查询
     */
    //获取总条数
    public Integer totalCount(@Param("d_dormbuilding") String d_dormbuilding, @Param("a_name") String a_name,@Param("s_dormitoryid") Integer s_dormitoryid);
    //获取用户列表
    public List<Dormitory> getDormitoryList(@Param("d_dormbuilding") String d_dormbuilding, @Param("a_name") String a_name, @Param("s_dormitoryid") Integer s_dormitoryid, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    //获取人员用户列表
    public List<Dormitory> getDormitoryStuList(@Param("s_dormitoryid") Integer s_dormitoryid);


    public int addDormitory(Dormitory dormitory);    //添加宿舍信息
    public int deleteDormitory(Integer d_id);   //删除宿舍信息
    public int updateDormitory(Dormitory dormitory); //修改宿舍信息
    public Dormitory findDormitoryById(Integer d_id);
    public List<Dormitory> getAll();
}
