package com.example.StudentApp.beans;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "student",uniqueConstraints = @UniqueConstraint(columnNames ="semail"))
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sid;
	
	@Column(name="sname")
	private String sname;
	
	@Column(name="semail")
	private String semail;
	
	private String spassword;
	
	@ManyToMany(fetch =FetchType.EAGER, cascade =CascadeType.ALL)
	@JoinTable( 
			name="students_roles",
			joinColumns =@JoinColumn(
			         name ="student_sid",referencedColumnName="sid"),
			inverseJoinColumns =@JoinColumn(
					         name ="role_id",referencedColumnName="id"))
	
	private Collection<Role> roles;
	
	public Student() {
		
	}
	
	// Constructors

	public Student(String sname, String semail, String spassword, Collection<Role> roles) {
		super();
		this.sname = sname;
		this.semail = semail;
		this.spassword = spassword;
		this.roles = roles;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public String getSpassword() {
		return spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	
	
	

	
	

}

// uniqueConstraints = @UniqueConstraint(columnNames ="semail")