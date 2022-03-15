package com.springcrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springcrud.beans.Student;
import com.springcrud.dao.StudentDao;



@Controller
public class StudentController {
	
	@Autowired
	StudentDao dao;
	@RequestMapping(value="/stuform", method=RequestMethod.GET)
	public String showForm(Model m){
		m.addAttribute("stu", new Student());
		System.out.println("show Form");
		return "stuform";
		
	}
	
	
//	@RequestMapping("/Login")
//	public String submitForm( @Valid @ModelAttribute("stu") Student s, BindingResult br)
//	{
//		if(br.hasErrors())
//		{
//			return "Validatestu";
//		}
//		else
//		{
//		return "Login";
//		}
//	}
//	

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("stu")Student stu){
		dao.insert(stu);
		return "redirect:/viewstu";
	}
	@RequestMapping("/viewstu")
	public String viewstu(Model m){
		List<Student> stuList= dao.getStudentsDetails();
		for(Student e : stuList){
			System.out.println(e.getSid());
		}
		m.addAttribute("stuList",stuList);
		return "viewstu";
	}
	
	@RequestMapping(value="/Login")
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}
	
	@RequestMapping(value="/Hello")
	public String hello() {
		 
		return "Hello";
	}
	
	@RequestMapping(value="/valstu")
	public String valstu() {
		return "valstu";
	}
	
	@RequestMapping(value="/valdata")
	public String valdata() {
		return "valstu";
	}
	@RequestMapping(value="/quizimg")
	public String quizimg() {
		
		return "quiz";
	}
	
	
	@RequestMapping(value="/editstu/{sid}")
	public String edit(@PathVariable int sid, Model m){
		Student stu=dao.getStuId(sid);
		m.addAttribute("stu",stu);
		return "stueditform";
	}
	@RequestMapping(value="/editsave",method=RequestMethod.POST)
	public String editSave(@ModelAttribute("stu") Student stu){
		dao.update(stu);
		return "redirect:/viewstu";
	}
	
	@RequestMapping(value="/deletestu/{sid}")
	public String delete(@PathVariable int sid){
		dao.delete(sid);
		return "redirect:/viewstu";
	}

}
