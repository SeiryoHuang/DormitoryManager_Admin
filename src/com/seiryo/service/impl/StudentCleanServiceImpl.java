package com.seiryo.service.impl;

import com.seiryo.dao.StudentGradeDao;
import com.seiryo.po.DormGrade;
import com.seiryo.po.PageInfo;
import com.seiryo.po.Stgrade;
import com.seiryo.service.StudentCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("studentCleanService")
@Transactional
public class StudentCleanServiceImpl implements StudentCleanService {

    @Autowired
    private StudentGradeDao dao;

    @Override
    public PageInfo<Stgrade> findPageInfo(Integer g_id, Integer s_studentid, String s_name, Integer s_grade, Integer s_classid, Integer s_dormitoryid, Date create_time, Date update_time, Integer pageIndex, Integer pageSize) {
        PageInfo<Stgrade> pi = new PageInfo<Stgrade>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = dao.totalCount(g_id, s_studentid,s_name,s_grade,s_classid,s_dormitoryid,create_time,update_time);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<Stgrade> stgrades = dao.getStudentGradeList(g_id, s_studentid,s_name,s_grade,s_classid,s_dormitoryid,create_time,update_time,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(stgrades);
        }
        return pi;
    }

    @Override
    public int addStudentClean(Stgrade stgrade) {
        return dao.addStudentClean(stgrade);
    }

    @Override
    public int deleteStudentClean(Integer g_id) {
        return dao.deleteStudentClean(g_id);
    }

    @Override
    public int updateStudentClean(Stgrade stgrade) {
        return dao.updateStudentClean(stgrade);
    }

    @Override
    public Stgrade findStudentCleanById(Integer g_id) {
        Stgrade s = dao.findStudentCleanById(g_id);
        return s;
    }

    @Override
    public List<Stgrade> getAll() {
        List<Stgrade> stgrades = dao.getAll();
        return stgrades;
    }
}
