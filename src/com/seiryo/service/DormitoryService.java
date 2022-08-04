package com.seiryo.service;

import com.seiryo.po.Admin;
import com.seiryo.po.Dormitory;
import com.seiryo.po.PageInfo;

import java.util.List;

/**
 * 用户Service层接口
 */
public interface DormitoryService {
	// 查询
	public Dormitory findDormitory(Dormitory dormitory);

	//找到所有所有数据
	public List<Dormitory> getAll();

	//分页查询
	public PageInfo<Dormitory> findPageInfo(String d_dormbuilding,String a_name, Integer s_dormitoryid, Integer pageIndex, Integer pageSize);
	//分页查询人员信息
	public List<Dormitory> findStu(Integer s_dormitoryid);

	public int addDormitory(Dormitory dormitory);    //添加宿舍信息
	public int deleteDormitory(Integer d_id);   //删除宿舍信息
	public int updateDormitory(Dormitory dormitory); //修改宿舍信息
	public Dormitory findDormitoryById(Integer d_id);
}
