package com.seiryo.service.impl;

import com.seiryo.dao.DormGradeDao;
import com.seiryo.po.Admin;
import com.seiryo.po.DormGrade;
import com.seiryo.po.PageInfo;
import com.seiryo.service.DormCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("dormCleanService")
@Transactional
public class DormCleanServiceImpl implements DormCleanService {

    @Autowired
    private DormGradeDao dao;
    @Override
    public PageInfo<DormGrade> findPageInfo(Integer g_id, Integer d_id, String d_dormbuilding, Integer pageIndex, Integer pageSize, Integer d_grade) {
        PageInfo<DormGrade> pi = new PageInfo<DormGrade>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = dao.totalCount(g_id,d_id,d_dormbuilding,d_grade);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<DormGrade> dormGrades = dao.getdormGradeList(g_id,d_id,d_dormbuilding,d_grade,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(dormGrades);
        }
        return pi;
    }

    @Override
    public int addDormClean(DormGrade dormGrade) {
        return dao.addDormClean(dormGrade);
    }

    @Override
    public int deleteDormClean(Integer g_id) {
        return dao.deleteDormClean(g_id);
    }

    @Override
    public int updateDormClean(DormGrade dormGrade) {
        return dao.updateDormClean(dormGrade);
    }

    @Override
    public DormGrade findDormCleanById(Integer g_id) {
        DormGrade d = dao.findDormCleanById(g_id);
        return d;
    }

    @Override
    public List<DormGrade> getAll() {
        List<DormGrade> dormGrades = dao.getAll();
        return dormGrades;
    }
}
