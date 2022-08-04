package com.seiryo.service;

import com.seiryo.po.DormRepair;
import com.seiryo.po.PageInfo;

import java.util.List;

/**
 * 用户Service层接口
 */
public interface DormRepairService {
	// 查询
	public DormRepair findDormRepair(DormRepair dormRepair);

	//找到所有所有数据
	public List<DormRepair> getAll();

	//分页查询
	public PageInfo<DormRepair> findPageInfo(String d_dormbuilding,Integer d_id,Integer pageIndex, Integer pageSize);

	public int addDormRepair(DormRepair dormRepair);    //添加宿舍信息
	public int deleteDormRepair(Integer r_id);   //删除宿舍信息
	public int updateDormRepair(DormRepair dormRepair); //修改宿舍信息
	public DormRepair findDormRepairById(Integer r_id);
}
