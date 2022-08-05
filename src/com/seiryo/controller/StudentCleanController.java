package com.seiryo.controller;


import com.seiryo.po.PageInfo;
import com.seiryo.po.Stgrade;
import com.seiryo.service.StudentCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class StudentCleanController {

    @Autowired
    private StudentCleanService studentCleanService;

    /**
     * 跳转到学生卫生
     */
    @RequestMapping(value = "/findStudentClean")
    public String findStudentClean(Integer g_id, Integer s_studentid, String s_name, Integer s_grade, Integer s_classid,
                                   Integer s_dormitoryid, Date create_time,Date update_time,
                                   Integer pageIndex, Integer pageSize, Model model){
        PageInfo<Stgrade> s = studentCleanService.findPageInfo(g_id,s_studentid,s_name,s_grade,s_classid,s_dormitoryid,
                create_time,update_time,pageIndex,pageSize);

        model.addAttribute("s",s);
        return "studentclean_list";
    }

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportstudentcleanlist" , method = RequestMethod.POST)
    @ResponseBody
    public List<Stgrade> exportStudenClean(){
        List<Stgrade> stgrades = studentCleanService.getAll();
        return stgrades;
    }

    /**
     * 添加学生卫生
     */
    @RequestMapping(value = "/addStudentClean" ,method = RequestMethod.POST)
    @ResponseBody
    public String addStudentClean( @RequestBody Stgrade stgrade) {

        //admin.setA_password(MD5Util.MD5EncodeUtf8(admin.getA_password()));
        int a = studentCleanService.addStudentClean(stgrade);
        return "studentclean_list";
    }

    /**
     * 删除学生卫生
     */
    @RequestMapping( "/deleteStudentClean")
    @ResponseBody
    public String deleteStudentClean(Integer g_id) {
        int a = studentCleanService.deleteStudentClean(g_id);
        return "studentclean_list";
    }

    /**
     * 修改学生卫生信息
     */
    @RequestMapping( value = "/updateStudentClean", method = RequestMethod.POST)
    public String updateStudentClean(Stgrade stgrade) {

        //admin.setA_password(MD5Util.MD5EncodeUtf8(admin.getA_password()));
        int a = studentCleanService.updateStudentClean(stgrade);
        return "redirect:/findStudentClean";
    }

    /**
     * 根据学号搜索;将请求数据g_id写入参数g_id
     */
    @RequestMapping( "/findStudentCleanById")
    public String findStudentCleanById(Integer g_id, HttpSession session) {
        Stgrade s= studentCleanService.findStudentCleanById(g_id);
        session.setAttribute("s",s);
        return "studentclean_edit";
    }
}
