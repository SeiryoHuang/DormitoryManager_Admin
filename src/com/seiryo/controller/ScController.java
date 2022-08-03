package com.seiryo.controller;

import com.seiryo.po.Admin;
import com.seiryo.po.Clazz;
import com.seiryo.po.ClazzStudent;
import com.seiryo.po.PageInfo;
import com.seiryo.service.ClassService;
import com.seiryo.service.ScService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ScController {
    @Autowired
    ClassService classService;
    @Autowired
    ScService scService;
    @RequestMapping(value = "/findClassStudent")
    public String findClassStudent(String c_classid,String c_classname,  Model model) {
        List<Clazz> clazzes = classService.findClassByNI(c_classname,c_classid);
        List<ClazzStudent> cs = new ArrayList<ClazzStudent>();
        for(Clazz clazz:clazzes){
            ClazzStudent clazzStudent = new ClazzStudent();
            clazzStudent.setC_classid(clazz.getC_classid());
            clazzStudent.setC_classname(clazz.getC_classname());
            clazzStudent.setC_counsellor(clazz.getC_counsellor());
            clazzStudent.setC_id(clazz.getC_id());
            String id = clazz.getC_classid();
            clazzStudent.setStudents(scService.findStudentByclass(id));
            cs.add(clazzStudent);
        }
        model.addAttribute("cs",cs);


        return "class_Studentlist";
    }
}
