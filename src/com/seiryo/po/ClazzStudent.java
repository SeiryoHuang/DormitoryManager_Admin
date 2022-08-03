package com.seiryo.po;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClazzStudent {
    private Integer c_id;
    private String c_classid;
    private String c_classname;
    private String c_counsellor;
    private List<Student> students = new ArrayList<Student>();

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_classid() {
        return c_classid;
    }

    public void setC_classid(String c_classid) {
        this.c_classid = c_classid;
    }

    public String getC_classname() {
        return c_classname;
    }

    public void setC_classname(String c_classname) {
        this.c_classname = c_classname;
    }

    public String getC_counsellor() {
        return c_counsellor;
    }

    public void setC_counsellor(String c_counsellor) {
        this.c_counsellor = c_counsellor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
