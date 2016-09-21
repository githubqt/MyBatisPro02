package com.java1234.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import com.java1234.model.Student;


public interface StudentMapper {

	public List<Student> searchStudents(Map<String,Object> map);
	
	public List<Student> searchStudents2(Map<String,Object> map);
	
	public List<Student> searchStudents3(Map<String,Object> map);
	
	public List<Student> searchStudents4(Map<String,Object> map);
	
	public List<Student> searchStudents5(Map<String,Object> map);
	
	public List<Student> searchStudents6(String name,int age);
	
	public int updateStudent(Student student);
	
	public int insertStudent(Student student);
	
	public Student getStudentById(Integer id);
	
	@Select("select * from t_student where id=#{id}") 
	public Student getStudentById1(Integer id);
	
	public List<Student> findStudents(RowBounds rowBounds);
	
	@Select("select * from t_student")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="age",property="age")
	})
	public List<Student> findStudents0();
	
	public List<Student> findStudents2(Map<String,Object> map);
	
}
