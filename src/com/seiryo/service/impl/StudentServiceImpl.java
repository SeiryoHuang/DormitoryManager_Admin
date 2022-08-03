package com.seiryo.service.impl;


import com.seiryo.dao.StudentDao;
import com.seiryo.po.PageInfo;
import com.seiryo.po.Student;
import com.seiryo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	@Override
	public PageInfo<Student> findPageInfo(String s_name, Integer s_studentid,Integer s_classid,
										  String s_classname, Integer pageIndex, Integer pageSize) {
		PageInfo<Student> pi = new PageInfo<Student>();
		pi.setPageIndex(pageIndex);
		pi.setPageSize(pageSize);
		Integer totalCount = studentDao.totalCount(s_name,s_studentid,s_classid,s_classname);
		if (totalCount>0){
			pi.setTotalCount(totalCount);
		List<Student> studentList =	studentDao.getStudentList(s_name,s_studentid,s_classid,s_classname,
				     (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
		  pi.setList(studentList);
		}
		return pi;
	}

	@Override
	public List<Student> getAll(){
		List<Student> studentList = studentDao.getAll();
		return studentList;
	}

	@Override
	public int deleteStudent(Integer s_id) {
		return studentDao.deleteStudent(s_id);
	}
	@Override
	public  int addStudent(Student student) {
		return studentDao.addStudent(student);
	}
	@Override
	public int updateStudent(Student student) { return studentDao.updateStudent(student); }
	@Override
	public Student findStudentById (Integer s_id){
		Student s = studentDao.findStudentById(s_id);
         return  s;
	}


}
