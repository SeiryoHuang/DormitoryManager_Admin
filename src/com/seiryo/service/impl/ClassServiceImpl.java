package com.seiryo.service.impl;

import com.seiryo.dao.ClassDao;
import com.seiryo.po.Admin;
import com.seiryo.po.Clazz;
import com.seiryo.po.PageInfo;
import com.seiryo.service.ClassService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("ClassService")
@Transactional
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassDao classDao;
    @Override
    public Integer totalCount(String c_classname, Integer c_id) {
        return classDao.totalCount(c_classname,c_id);
    }

    @Override
    public PageInfo<Clazz> getClassList(String c_classname, String c_classid, String c_counsellor,Integer c_id, Integer pageIndex, Integer pageSize) {
        PageInfo<Clazz> pi = new PageInfo<Clazz>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = classDao.totalCount(c_classname,c_id);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示管理员信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Clazz> clazzList =	classDao.getClassList(c_classname,c_classid,c_counsellor,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(clazzList);
        }
        return pi;
    }

    @Override
    public int addClass(Clazz clazz) {
        return classDao.addClass(clazz);
    }

    @Override
    public int deleteClass(Integer c_id) {
        return classDao.deleteClass(c_id);
    }

    @Override
    public int updateClass(Clazz clazz) {
        return classDao.updateClass(clazz);
    }

    @Override
    public Clazz findClassById(Integer c_id) {
        return classDao.findClassById(c_id);
    }

    @Override
    public List<Clazz> getAll() {
        return classDao.getAll();
    }

    @Override
    public List<Clazz> findClassByNI(String c_classname, String c_classid) {
        return classDao.findClassByNI(c_classname,c_classid);
    }
}
