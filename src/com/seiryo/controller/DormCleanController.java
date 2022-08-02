package com.seiryo.controller;

import com.seiryo.po.DormGrade;
import com.seiryo.po.PageInfo;
import com.seiryo.service.DormCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DormCleanController {

    @Autowired
    private DormCleanService dormCleanService;

    /**
     * 跳转到宿舍卫生
     */
    @RequestMapping(value = "/findDormClean")
    public String findDormClean(Integer g_id,Integer d_id,String d_dormbuilding,Integer pageIndex,
                            Integer pageSize, Model model,Integer d_grade) {

        PageInfo<DormGrade> d = dormCleanService.findPageInfo(g_id,d_id,d_dormbuilding,pageIndex,
                pageSize,d_grade);
        model.addAttribute("d",d);
        return "dormclean_list";
    }

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportdormcleanlist" , method = RequestMethod.POST)
    @ResponseBody
    public List<DormGrade> exportDormclean(){
        List<DormGrade> DormGrade = dormCleanService.getAll();
        return DormGrade;
    }

    /**
     * 添加宿舍
     */
    @RequestMapping(value = "/addDormClean" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDormClean( @RequestBody DormGrade dormGrade) {

        //admin.setA_password(MD5Util.MD5EncodeUtf8(admin.getA_password()));
        int a = dormCleanService.addDormClean(dormGrade);
        return "dormclean_list";
    }

    /**
     * 删除宿舍
     */
    @RequestMapping( "/deleteDormClean")
    @ResponseBody
    public String deleteDormClean(Integer g_id) {
        int a = dormCleanService.deleteDormClean(g_id);
        return "dormclean_list";
    }

    /**
     * 修改宿舍信息
     */
    @RequestMapping( value = "/updateDormClean", method = RequestMethod.POST)
    public String updateDormClean(DormGrade dormGrade) {

        //admin.setA_password(MD5Util.MD5EncodeUtf8(admin.getA_password()));
        int a = dormCleanService.updateDormClean(dormGrade);
        return "redirect:/findDormClean";
    }

    /**
     * 根据宿舍Id搜索;将请求数据g_id写入参数g_id
     */
    @RequestMapping( "/findDormCleanById")
    public String findAdminById(Integer g_id, HttpSession session) {
        DormGrade d= dormCleanService.findDormCleanById(g_id);
        session.setAttribute("d",d);
        return "dormclean_edit";
    }
}
