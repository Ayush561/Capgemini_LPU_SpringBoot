//package com.Employee.EmployeeSpringMVCBootAssignment.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.Employee.EmployeeSpringMVCBootAssignment.Entity.Employee;
//import com.Employee.EmployeeSpringMVCBootAssignment.Repository.EmployeeRepository;
//
//@Service
//public class EmployeeService {
//	
//	@Autowired
//	EmployeeRepository jpa;
//	
//	
//	@GetMapping("/register")
//	public String register() {
//		return "register";
//	}
//	
//	@PostMapping("/create-account")
//	public String createAccount(@ModelAttribute Employee emp) {
//		jpa.save(emp);
//		return "success";
//		
//	}
//	
//	@GetMapping
//	public void findAllEmployee() {
//		
//	}
//
//}
