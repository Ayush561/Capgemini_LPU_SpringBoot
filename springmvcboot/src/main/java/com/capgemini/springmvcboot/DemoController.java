package com.capgemini.springmvcboot;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
//	public String register(HttpServletRequest request) {  When we are storing the data manually from the URL and using request.getParameter() we are storing all the fields.
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
	
	//Login Page
	@GetMapping("/login")
	public String showLoginPage() {
	    return "login";
	}
	
	//Login check
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute Users user) {
		String email = user.getEmail();
		String pass = user.getPassword();
	    Users validUser = jpa.findByEmailAndPassword(email,pass); 

	    if (validUser != null) {
	        return "loginsuccess";
	    } else {
	        //return "loginfail";  //Either we can go to loginfail page or we can again go to login page to give user another chance.
	        return "redirect:login";
	    }
	}
	
	@GetMapping("/hi")
	public ModelAndView sendData() {  //we want to send data from here(backend) to frontend.For that we need to use either ModelAndView<Concrete class> or Model<Interface>
		ModelAndView m = new ModelAndView();
//		m.addObject("msg","Miller"); //What data you want to send to the frontEnd. It sends the data in key value pair("msg","Miller")
//		m.setViewName("abc");  //For which page you want to send the message as Miller. We will create a abc.jsp in webapp-WEB-INF-view.
//		
		//Now we want to give list of name
		List<String> names = List.of("Miller","Allen","Ben");
		m.addObject("msg",names);  //This will print the list on the browser
		m.setViewName("abc");  
		return m;
		
		
		//Now we want to iterate the list instead of printing it on the browser, so we need to add some libraries Jakarta Standard Tag Library API(version 3.0.2) and Jakarta Standard Tag Library Implementation(version 3.0.1)
	}
	
	

}
