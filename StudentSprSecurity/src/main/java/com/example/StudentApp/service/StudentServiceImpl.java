package com.example.StudentApp.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.StudentApp.beans.Role;
import com.example.StudentApp.beans.Student;
import com.example.StudentApp.repo.StudentRepository;
import com.example.StudentApp.web.dto.StudentRegistrationDto;

@Service 
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	
	

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	@Override
	public Student save(StudentRegistrationDto registrationDto) {
		// TODO Auto-generated method stub
		//Student registration
		Student student=new Student(registrationDto.getSname(),registrationDto.getSemail(),passwordEncoder.encode(registrationDto.getSpassword()), Arrays.asList(new Role("ROLE_STUDENT")));
		return studentRepository.save(student);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Student student=studentRepository.findBySemail(username);
		if(student==null) {
			throw new UsernameNotFoundException("Invalid Studentname or password");
		}
		return new org.springframework.security.core.userdetails.User(student.getSemail(), student.getSpassword(), mapRolesToAuthorities(student.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		// TODO Auto-generated method stub
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	

	

}
