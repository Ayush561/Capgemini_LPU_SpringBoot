package com.Employee.EmployeeSpringMVCBootAssignment.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	        return new ModelAndView("success");
	    }
	}
	
	
	//There is another way to do it using Model<Interface>, In this we don't use setview we return the jps page and we use addAttribute instead of addObject
//	@PostMapping("/create-account")
//	public String createAccount(@ModelAttribute Employee emp,Model model) {
//
//	    Optional<Employee> e = jpa.findById(emp.getEmail());
//
//	    if (e.isPresent()) {
//
//	        //ModelAndView m = new ModelAndView();
//	        model.addAttribute("emp",e.get());
//	        //m.setViewName("userexist");
//	        return "userexist";
//
//	    } else {
//
//	        jpa.save(emp);
//	        //return new ModelAndView("success");
//	        return "success";
//	    }
//	}
	
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
				m.addObject("employees", list);
				m.addObject("isAdmin", true);
				m.setViewName("listEmployee");
				return m;
			}
			else {
				ModelAndView m = new ModelAndView();
				m.addObject("emp", validEmp);
				m.setViewName("loginsuccess");
				return m;
			}
		}
		else {
			ModelAndView m = new ModelAndView();
			m.addObject("error", "Invalid Email or Password");
			m.setViewName("validate");
			return m;
		}
	}
	
	
	@PostMapping("/delete-selected")
	public ModelAndView deleteSelected(
			@RequestParam(value = "selectedEmails", required = false) List<String> emails) {

		if (emails != null) {
			for (String email : emails) {
				jpa.deleteById(email);
			}
		}

		List<Employee> list = jpa.findAll();

		ModelAndView m = new ModelAndView();
		m.addObject("employees", list);
		m.addObject("isAdmin", true);
		m.setViewName("listEmployee");

		return m;
	}
	
	
	@GetMapping("/update/{email}")
	public ModelAndView openUpdatePage(@PathVariable String email) {

	    Optional<Employee> emp = jpa.findById(email);

	    ModelAndView m = new ModelAndView();

	    if(emp.isPresent()) {
	        m.addObject("emp", emp.get());
	        m.setViewName("updateEmployee");
	    }

	    return m;
	}
	
	
	@PostMapping("/update-employee")
	public ModelAndView updateEmployee(@ModelAttribute Employee emp) {

	    Optional<Employee> existing = jpa.findById(emp.getEmail());

	    if(existing.isPresent()) {

	        Employee e = existing.get();

	        e.setName(emp.getName());
	        e.setRole(emp.getRole());
	        e.setSalary(emp.getSalary());

	        jpa.save(e);
	    }

	    List<Employee> list = jpa.findAll();

	    ModelAndView m = new ModelAndView();
	    m.addObject("employees", list);
	    m.addObject("isAdmin", true);
	    m.setViewName("listEmployee");

	    return m;
	}
	
	
}