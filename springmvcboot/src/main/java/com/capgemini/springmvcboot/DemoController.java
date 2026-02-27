package com.capgemini.springmvcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class DemoController {
	
	
	@GetMapping("/hello")
	public String getHi() {
		return "welcome";
	}
	
	@GetMapping("/register") 
	public String createAccount() {
		return "register";
	}
	
	
	//@GetMapping("/create-account")  //This end point we need to give in the jsp page in action part of form tag
	//when we use get mapping thne url shows the entered data which is not good, To encrypt it we use Post mapping
//	@PostMapping("/create-account")
//	public String register(HttpServletRequest request) {
//		String name=request.getParameter("name");
//		String email=request.getParameter("email");
//		String number=request.getParameter("number");
//		
//		System.out.println(name+" | "+email+" | "+number);
//		
//		return "success";
//		
//	}
//	
	
	//We have created a class Users which will store the values of the attributes getting from the URL
//	@PostMapping("create-account")
//	public String register(@ModelAttribute Users user) {  //We will use @ModelAttribute to store the values from URL to objects.
//		System.out.println(user.getEmail());
//		System.out.println(user.getName());
//		System.out.println(user.getNumber());
//		return "success";
//		
//	}
	//We'll save it in DATABASE so we need to create similar method that's why commenting it
	
	
	@Autowired
	UsersJPARepository jpa;
	
	//To register user
	@PostMapping("create-account")
	public String register(@ModelAttribute Users user) {
		jpa.save(user);
		return "success";
		
	}
	
	//Login check
	@GetMapping("/login")
	public String showLoginPage() {
	    return "login";
	}
	
	
	@PostMapping("/logincheck")
	public String login(@ModelAttribute Users user) {
		String email = user.getEmail();
		String pass = user.getPassword();
	    Users validUser = jpa.findByEmailAndPassword(email,pass);

	    if (validUser != null) {
	        return "loginsuccess";
	    } else {
	        return "loginfail";
	    }
	}
	

}
