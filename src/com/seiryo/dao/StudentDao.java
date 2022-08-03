package com.seiryo.dao;
import com.seiryo.po.Student;
import org.apache.ibatis.annotations.Param;


import java.util.List;


public interface StudentDao {

     public Integer totalCount(@Param("s_name") String s_name, @Param("s_studentid") Integer s_studentid,
                               @Param("s_classid") Integer s_classid, @Param("s_classname") String s_classname);
     public List<Student> getStudentList(@Param("s_name") String s_name, @Param("s_studentid") Integer s_studentid, @Param("s_classid") Integer s_classid,
                                         @Param("s_classname") String s_classname, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

	 public int deleteStudent(Integer s_id);
	 public int addStudent(Student student);
	 public int updateStudent(Student student);
	 public Student findStudentById(Integer s_id);
	 public List<Student> getAll();
}
