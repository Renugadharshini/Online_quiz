package com.example.StudentApp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.StudentApp.beans.Student;
import com.example.StudentApp.web.dto.StudentRegistrationDto;

public interface StudentService extends UserDetailsService {
 Student save (StudentRegistrationDto registrationDto);
}
