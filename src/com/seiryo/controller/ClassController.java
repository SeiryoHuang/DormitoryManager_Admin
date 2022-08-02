package com.seiryo.controller;

import com.seiryo.po.Admin;
import com.seiryo.po.Clazz;
import com.seiryo.po.PageInfo;
import com.seiryo.service.ClassService;
import com.seiryo.util.MD5Util;
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
public class ClassController {
    @Autowired
    private ClassService classService;
    @RequestMapping(value = "/findClass")
    public String findClass(String c_classname, String c_classid, String c_counsellor,Integer c_id, Integer pageIndex, Integer pageSize,Model model) {

        PageInfo<Clazz> ci = classService.getClassList(c_classname,c_classid,c_counsellor,c_id,pageIndex,pageSize);
        model.addAttribute("ci",ci);
        return "class_list";
    }
    @RequestMapping(value = "/exportclasslist" , method = RequestMethod.POST)
    @ResponseBody
    public List<Clazz> exportclasslist(){
        List<Clazz> clazzList = classService.getAll();
        return clazzList;
    }
    @RequestMapping(value = "/addClass" ,method = RequestMethod.POST)
    @ResponseBody
    public String addClass( @RequestBody Clazz clazz) {

        int a = classService.addClass(clazz);
        return "class_list";
    }
    @RequestMapping( "/deleteClass")
    @ResponseBody
    public String deleteClass(Integer c_id) {
        int a = classService.deleteClass(c_id);
        return "class_list";
    }
    @RequestMapping( value = "/updateClass", method = RequestMethod.POST)
    public String updateClass(Clazz clazz) {
        int a = classService.updateClass(clazz);
        return "redirect:/findClass";
    }
    @RequestMapping( "/findClassById")
    public String findClassById(Integer c_id, HttpSession session) {
        Clazz c= classService.findClassById(c_id);
        session.setAttribute("c",c);
        return "class_edit";
    }
}
