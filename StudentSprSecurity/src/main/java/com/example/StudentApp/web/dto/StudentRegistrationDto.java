package com.example.StudentApp.web.dto;

public class StudentRegistrationDto {
	
	private String sname;
	private String semail;
	private String spassword;
	
	public StudentRegistrationDto() {
		
	}

	public StudentRegistrationDto(String sname, String semail, String spassword) {
		super();
		this.sname = sname;
		this.semail = semail;
		this.spassword = spassword;
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
	
	

}
