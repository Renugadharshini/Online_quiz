package com.example.StudentApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentApp.beans.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

	Student findBySemail(String semail);
	
}
