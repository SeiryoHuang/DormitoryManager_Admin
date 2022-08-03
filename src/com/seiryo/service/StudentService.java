package com.seiryo.service;
import com.seiryo.po.PageInfo;
import com.seiryo.po.Student;


import java.util.List;


public interface StudentService {


	public PageInfo<Student> findPageInfo(String s_name, Integer s_studentid, Integer s_classid,
                                          String s_classname, Integer pageIndex, Integer pageSize);

	public int deleteStudent(Integer s_id);
	public int addStudent(Student student);
	public int updateStudent(Student student);
	public Student findStudentById(Integer s_id);
	public List<Student> getAll();

}
