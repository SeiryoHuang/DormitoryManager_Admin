package com.seiryo.service.impl;

import com.seiryo.dao.DormRepairDao;
import com.seiryo.po.DormRepair;
import com.seiryo.po.PageInfo;
import com.seiryo.service.DormRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 */
@Service("dormRepairService")
@Transactional
public class DormRepairServiceImpl implements DormRepairService {
	// 注入UserDao
	@Autowired
	private DormRepairDao dormRepairDao;

	//管理登陆查询
	@Override
	public DormRepair findDormRepair(DormRepair dormRepair) {
		DormRepair a = dormRepairDao.findDormRepair(dormRepair);
		return a;
	}

	@Override
	public List<DormRepair> getAll(){

		List<DormRepair> dormRepairList = dormRepairDao.getAll();
		return dormRepairList;
    }

	@Override
	public PageInfo<DormRepair> findPageInfo(String d_dormbuilding,Integer d_di,Integer pageIndex, Integer pageSize) {
		PageInfo<DormRepair> pi = new PageInfo<DormRepair>();
		pi.setPageIndex(pageIndex);
		pi.setPageSize(pageSize);
		//获取总条数
		Integer totalCount = dormRepairDao.totalCount(d_dormbuilding,d_di);
		if (totalCount>0){
			pi.setTotalCount(totalCount);
			//每一页显示宿舍信息数
			//currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
			List<DormRepair> dormRepairList =	dormRepairDao.getDormRepairList(d_dormbuilding,d_di,(pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
			pi.setList(dormRepairList);
		}
		return pi;
	}

	//添加宿舍信息
	@Override
	public int addDormRepair(DormRepair dormRepair) {
		return dormRepairDao.addDormRepair(dormRepair);
	}

	//通过id删除宿舍信息
	@Override
	public int deleteDormRepair(Integer r_id) {
		return dormRepairDao.deleteDormRepair(r_id);
	}

	//修改宿舍信息
	@Override
	public int updateDormRepair(DormRepair dormRepair) {
		return dormRepairDao.updateDormRepair(dormRepair);
	}

	@Override
	public DormRepair findDormRepairById (Integer r_id){
		DormRepair d = dormRepairDao.findDormRepairById(r_id);
		return  d;
	}
}
