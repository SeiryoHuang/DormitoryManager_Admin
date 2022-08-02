package com.seiryo.service;

import com.seiryo.po.Admin;
import com.seiryo.po.DormGrade;
import com.seiryo.po.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;

public interface DormCleanService {
    public PageInfo<DormGrade> findPageInfo(Integer g_id,Integer d_id, String d_dormbuilding, Integer pageIndex,
                                             Integer pageSize, Integer d_grade);

    public int addDormClean(DormGrade dormGrade);

    public int deleteDormClean(Integer g_id);

    public int updateDormClean(DormGrade dormGrade);

    public DormGrade findDormCleanById(Integer g_id);

    public List<DormGrade> getAll();
}
