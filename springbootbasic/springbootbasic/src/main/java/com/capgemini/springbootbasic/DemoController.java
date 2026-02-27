package com.capgemini.springbootbasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.*;


//@Controller  //Controller will take http request and returns http response, Controller will always return a webpage.
//Controller annotation has the problem that It will always send the response as view but we want it as Data (for now) not view so we will use @RestController
@RestController  //It will give the response as Data and not view
public class DemoController {

	
	//@GetMapping("/a")  //This is the end point , whenever controller gets a request it will check for the endpoint if method with endpoint is present in the Controller class or not
	//http://localhost:/5050/a if we give this on browser, it will send the request to controller and controller will search for end point i.e /a, if it is present it will return it otherwise it will return 404.
	
	@PostMapping("/a")  //We can't use Post,delete,put,patch request in the browser, It will give error as 405 (Method not allowed). For this we will use Postman(Another type of browser) that accepts all these requests that Normal browser don't.
	//@ResponseBody  //Isko use krte hi method me jo bhi present hai as it is webpage me print hoga, but isko hata diya to fir method ke andar jo b hoga wo src/main/resources/static location par jaake check karega jo b file present h ki nahi, agar nahi hoga to webpage par 404 status aayega meaning page not found
	public List<String> hello() {
		//return "Hello.html"; //We have remove the responseBody annotation means it will search the file present in return statement in static folder in src/main/resources.
		return List.of("Miller","Brevis","Markram","Lungi");  //this will be shown in the web page of our URL http://localhost:/5050/a for this particular method as /a is the end point for this method
		
	}
	
	
	@PostMapping("/add")
	public String createPlayer(@RequestBody Cricketer c) {  //The values which will be send by the postman browser, those values will be set in the attributes of Cricketer object
		//@RequestBody will convert the Json Data that we will send from the browser to Java data
		//inside postman we need to write the url(http://localhost:5050/add) and then below there will be an option body we need to click on that then select Json format and then write in the same format as below
		//{
//	    "name":"Miller",
//	    "role":"Baller",
//	    "runs":10000,
//	    "no_of_match":300,
//	    "average":35.5
//	}
		
		//All the fields name should match otherwise it would not store.
		
		//We need Parameterized constructor to set the values sent from the Postman browser. 
		System.out.println(c);
		return c.toString();
		
	}
	
	@PostMapping("/car")
	public String addCar(@RequestBody Car car) {  //Inside car we have Engine object so we will do Nested Json Format.
		/*
		 * {
    		"brand":"Jaguar",
			"price":34500000,
    		"e":{
        		"fuelType":"Petrol",
        		"cc":750
    		}
		}
		 */
		System.out.println(car);
		return car.toString();
	}
	
	@PostMapping("/person")
	public String addPerson(@RequestBody Person person) {
		//We have a list in the person class so we will use the same format as below to fill the list from Postman
		/*
		 * {
    		"id":2,
    		"name":"Ayush",
    		"item":["Pen","Pencil","Erase"]
			}
		 */
		
		System.out.println(person);
		return person.toString();
	}
	
	@PostMapping("/college")
	public String addCollege(@RequestBody College college) {
		//We have List<Student> in college so we use the below format in Postman to pass values
		/*
		 * {
			"name":"LPU",
    		"location":"Amritsar",
    		"student":[{"name":"Ayush","branch":"CSE"},{"name":"Himani","branch":"MEC"}]
			}
		 */
		
		System.out.println(college);
		return college.toString();
	}
	
	
	//To perform CRUD operations we use JPARepository that we are extending in CAR2JPARepository so that we can Save the table in database and perform operations
	//We use AutoWired to inject dependency
	@Autowired
	Car2JPARepository car2jpa;
	@PostMapping("/Save-car2")
	public String createCar2(@RequestBody Car2 car2) {
		Car2 c2 = car2jpa.save(car2);
		return c2.toString();
	}
	
	
	@GetMapping("/find-id")
	public String getById(int id) {
		Optional<Car2> option=car2jpa.findById(id);  //By default the return type of findbyId is Optional for null check purpose
		return option.isPresent()?option.get().toString():"Data not exist";
	}
	
	
	@GetMapping("/find-all")  //This will work as select * from car2;
	public List<Car2> getAllById(){
		List<Car2> list = car2jpa.findAll();
		return list;
	}
	
	
	@DeleteMapping("/delete-id/{id}")
	//http://localhost:5050/delete-id/1  //in @PathVariable , no need to use ? delimeter.
	public boolean deleteCar2(@PathVariable int id) {
		Optional<Car2> option = car2jpa.findById(id);
		if(option.isPresent()) {
			car2jpa.delete(option.get());
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	@PutMapping("/update-car/{id}")
	public boolean updateCar2(@PathVariable int id,@RequestBody Car2 c) {
		
		Optional<Car2> option = car2jpa.findById(id);
		if(option.isPresent()) {
			Car2 car2 = option.get();
			car2.setBrand(c.getBrand());
			car2.setPrice(c.getPrice());
			car2jpa.save(car2);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//@PutMapping is for all the fields we want to update
	//@PathMapping is for some fields we want to update, there we can't use @PutMapping.
	// --> {"brand":"A"
	@PatchMapping("/update-car/{id}")
	//Here we have used the same endpoint for both Update bus here we are using @PatchMapping that will not create any confusion for DemoController to search, In postman we will select Patch then run the server
	public boolean updateCar2DataUsingPatchMapping(@PathVariable int id, @RequestBody Car2 c) {
		Optional<Car2> option = car2jpa.findById(id);
		if(option.isPresent()) {
			Car2 car = option.get();
			if(c.getBrand()!=null) {
				car.setBrand(c.getBrand());
			}
			else if(c.getPrice()!=0.0) {
				car.setPrice(c.getPrice());
			}
			car2jpa.save(car);
			return true;
		}
		else {
			return false;
		}
	}
	
	//Now we will search wrt price , for that we have added an abstract method in Car2JpaRepository interface.
	//
	@GetMapping("/find-price/{price}")
	public Car2 getCar2ByPrice(@RequestBody double price) {
		return car2jpa.getByPrice(price);
	}
	
	
	@DeleteMapping("/delete-brand/{brand}")
	public int deleteCar2ByBrand(@PathVariable String brand) {
		return car2jpa.deleteByBrand(brand);
	}
	
	
	//To throw exception
	@GetMapping("/find-id-exc/{id}")
	public String getByIdException(@PathVariable int id){
		Optional<Car2> option=car2jpa.findById(id); //By default the return type of findbyId is Optional for null check purpose
		if(option.isPresent()) {
			return option.get().toString();
		}
		else {
			throw new DataNotExist();
		}
		
	}
	
	//This block will work as catch block
	@ExceptionHandler(DataNotExist.class)
	public String handleException() {
		return "Exception Handle Method";
		
	}
	
	
	//We want to add a global exception that can handle all the exceptions then we will create a class ApplicationException that will handle all the exception. Check the annotations and way of writing in ApplicationException.java
	//Go to ApplicationException.java
	
}
