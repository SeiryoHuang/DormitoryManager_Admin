package com.seiryo.service.impl;

import com.seiryo.dao.AdminDao;
import com.seiryo.dao.DormitoryDao;
import com.seiryo.po.Admin;
import com.seiryo.po.Dormitory;
import com.seiryo.po.PageInfo;
import com.seiryo.service.AdminService;
import com.seiryo.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 */
@Service("dormitoryService")
@Transactional
public class DormitoryServiceImpl implements DormitoryService {
	// 注入UserDao
	@Autowired
	private DormitoryDao dormitoryDao;

	//管理登陆查询
	@Override
	public Dormitory findDormitory(Dormitory dormitory) {
		Dormitory a = dormitoryDao.findDormitory(dormitory);
		return a;
	}

	@Override
	public List<Dormitory> getAll(){

		List<Dormitory> dormitoryList = dormitoryDao.getAll();
		return dormitoryList;
    }

	@Override
	public PageInfo<Dormitory> findPageInfo(String d_dormbuilding,String a_name, Integer s_dormitoryid,Integer pageIndex, Integer pageSize) {
		PageInfo<Dormitory> pi = new PageInfo<Dormitory>();
		pi.setPageIndex(pageIndex);
		pi.setPageSize(pageSize);
		//获取总条数
		Integer totalCount = dormitoryDao.totalCount(d_dormbuilding,a_name, s_dormitoryid);
		if (totalCount>0){
			pi.setTotalCount(totalCount);
			//每一页显示宿舍信息数
			//currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
			List<Dormitory> dormitoryList =	dormitoryDao.getDormitoryList(d_dormbuilding,a_name, s_dormitoryid,
					(pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
			pi.setList(dormitoryList);
		}
		return pi;
	}
	//获取人员信息
	@Override
	public List<Dormitory> findStu(Integer s_dormitoryid) {
			List<Dormitory> dormitoryStuList =	dormitoryDao.getDormitoryStuList(s_dormitoryid);
			return dormitoryStuList;
	}

	//添加宿舍信息
	@Override
	public int addDormitory(Dormitory dormitory) {
		return dormitoryDao.addDormitory(dormitory);
	}

	//通过id删除宿舍信息
	@Override
	public int deleteDormitory(Integer d_id) {
		return dormitoryDao.deleteDormitory(d_id);
	}

	//修改宿舍信息
	@Override
	public int updateDormitory(Dormitory dormitory) {
		return dormitoryDao.updateDormitory(dormitory);
	}

	@Override
	public Dormitory findDormitoryById (Integer d_id){
		Dormitory d = dormitoryDao.findDormitoryById(d_id);
		return  d;
	}
}
