package com.seiryo.dao;

import com.seiryo.po.DormGrade;
import com.seiryo.po.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormGradeDao {
    public PageInfo<DormGrade> findPageInfo(Integer g_id, Integer d_id, String d_dormbuilding, Integer pageIndex,
                                            Integer pageSize, Integer d_grade);

    public int addDormClean(DormGrade dormGrade);

    public int deleteDormClean(Integer g_id);

    public int updateDormClean(DormGrade dormGrade);

    public DormGrade findDormCleanById(Integer g_id);

    public List<DormGrade> getAll();

    public Integer totalCount(@Param("g_id") Integer g_id, @Param("d_id") Integer d_id, @Param("d_dormbuilding")String d_dormbuilding,@Param("d_grade")Integer d_grade);

    public List<DormGrade> getdormGradeList(@Param("g_id")Integer g_id,@Param("d_id")Integer d_id,@Param("d_dormbuilding")String d_dormbuilding,
                                            @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize,@Param("d_grade")Integer d_grade);
}
