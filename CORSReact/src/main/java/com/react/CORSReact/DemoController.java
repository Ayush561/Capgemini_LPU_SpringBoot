package com.react.CORSReact;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")   //React is running on 3000 port and Springboot application is running on 8080, to match both we are using crossOrigin annotation
public class DemoController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "";
	}
	
	
	@GetMapping("/api/hello")
	public String getHi() {
		return "Ayush";
	}

}

