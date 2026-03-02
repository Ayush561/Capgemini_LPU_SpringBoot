package com.Employee.EmployeeSpringMVCBootAssignment.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import com.Employee.EmployeeSpringMVCBootAssignment.Entity.Employee;
import com.Employee.EmployeeSpringMVCBootAssignment.Repository.EmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository jpa;
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/create-account")
	public ModelAndView createAccount(@ModelAttribute Employee emp) {

	    Optional<Employee> e = jpa.findById(emp.getEmail());

	    if (e.isPresent()) {

	        ModelAndView m = new ModelAndView();
	        m.addObject("emp", e.get());
	        m.setViewName("userexist");
	        return m;

	    } else {

	        jpa.save(emp);

	        ModelAndView m = new ModelAndView();
	        m.setViewName("success");
	        return m;
	    }
	}
	
	@GetMapping("/check-user")
	public String checkUser() {
		return "validate";
	}
	
	@PostMapping("/validatecheck")
	public ModelAndView validateCheck(@ModelAttribute Employee emp) {
		
		String email = emp.getEmail();
		String password = emp.getPassword();
		
		Employee validEmp = jpa.findByEmailAndPassword(email, password);
		
		if(validEmp != null) {
			
			if(validEmp.getRole().equalsIgnoreCase("admin")) {
				
				List<Employee> list = jpa.findAll();
				
				ModelAndView m = new ModelAndView();
				m.addObject("msg", list);
				m.setViewName("listEmployee");
				return m;
			}
			else {
				ModelAndView m = new ModelAndView();
				m.addObject("emp",validEmp);
				m.setViewName("loginsuccess");
				return m;
			}
		}
		else {
			ModelAndView m = new ModelAndView();
			m.setViewName("validate");
			m.addObject("error", "Invalid Email or Password");
			return m;
		}
	}
}