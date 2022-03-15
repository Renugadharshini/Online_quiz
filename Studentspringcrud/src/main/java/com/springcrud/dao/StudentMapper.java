package com.springcrud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springcrud.beans.Student;



public class StudentMapper implements RowMapper<Student> {
	
	@Override
	public Student mapRow(ResultSet rs,int rowNum)throws SQLException{
		Student student =new Student();
		student.setSid(rs.getInt("sid"));
		student.setSname(rs.getString("sname"));
		student.setSemail(rs.getString("semail"));
		student.setSpassword(rs.getString("spassword"));
		return student;
		
	}
	
	

}
