package com.java1234.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.java1234.mappers.StudentMapper;
import com.java1234.model.Student;
import com.java1234.util.SqlSessionFactoryUtil;

public class StudentTest3 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(StudentTest3.class);
	private SqlSession sqlSession=null;
	private StudentMapper studentMapper=null;
	
	/**
	 * 测试方法前调用
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		sqlSession=SqlSessionFactoryUtil.openSession();
		studentMapper=sqlSession.getMapper(StudentMapper.class);
	}

	/**
	 * 测试方法后调用
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	
	@Test
	public void testFindStudent(){
		logger.info("查询学生");
		int offset=0,limit=3;
		RowBounds rowBounds=new RowBounds(offset,limit);
		List<Student> studentList=studentMapper.findStudents(rowBounds);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindStudent0(){
		logger.info("查询学生");
		List<Student> studentList=studentMapper.findStudents0();
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindStudent2(){
		logger.info("查询学生");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", 1);
		map.put("size", 3);
		List<Student> studentList=studentMapper.findStudents2(map);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	
	
}
