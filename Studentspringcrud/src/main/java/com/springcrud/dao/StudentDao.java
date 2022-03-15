package com.springcrud.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springcrud.beans.Student;

public class StudentDao {
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template){
		this.template=template;
	}
	public int insert(Student stu){
		String sql="insert into Studt(sid,sname,semail,spassword)values(?,?,?,?)";
		int ans=template.update(sql,stu.getSid(),stu.getSname(),stu.getSemail(),stu.getSpassword());
		return ans;
	}

	public int update(Student stu){
		String sql="update Studt set sname=?, semail=? ,spassword=? where sid=?";
		int ans=template.update(sql,stu.getSname(),stu.getSemail(),stu.getSpassword(),stu.getSid());
		return ans;
	}
	public int delete(int id){ 
		String sql="delete from Studt where sid=?";
		return template.update(sql,id);
	}
	public Student getStuId(int id){
		String sql="select * from Studt where sid=?";
		Student  stu=template.queryForObject(sql,new Object[]{id},new StudentMapper());
		return stu;
	}
	
	public List<Student> getStudentsDetails(){
		String sql="select * from Studt ";
		List<Student>stuList=template.query(sql,new StudentMapper());
		return stuList;
	}

}
