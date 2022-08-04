package com.seiryo.dao;

import com.seiryo.po.DormRepair;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 宿舍DAO层接口
 */
public interface DormRepairDao {
    
    public DormRepair findDormRepair(DormRepair dormRepair);

    /**
     * 进行分页查询
     */
    //获取总条数
    public Integer totalCount(@Param("d_dormbuilding") String d_dormbuilding,@Param("d_id") Integer d_id);
    //获取用户列表
    public List<DormRepair> getDormRepairList(@Param("d_dormbuilding") String d_dormbuilding,@Param("d_id") Integer d_id,@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    public int addDormRepair(DormRepair dormRepair);    //添加宿舍信息
    public int deleteDormRepair(Integer r_id);   //删除宿舍信息
    public int updateDormRepair(DormRepair dormRepair); //修改宿舍信息
    public DormRepair findDormRepairById(Integer r_id);
    public List<DormRepair> getAll();
}
