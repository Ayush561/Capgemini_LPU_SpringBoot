package com.practice.InMemoryCachePractice.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.InMemoryCachePractice.Entity.Product;
import com.practice.InMemoryCachePractice.Service.ProductService;

@RestController
public class ProductController {
	
	//ABOVE SPRINGBOOTAPPLICATION WE WILL USE @EnanbleCaching
	
	private ProductService service;
	
	public ProductController(ProductService service) {
		this.service=service;
	}
	
	
	@PostMapping("/create")
	public Product addProduct(@RequestBody Product p) {
		return service.addProduct(p);
	}

	
	@GetMapping("/find-id/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getById(id);
	}
	
	//When you find the id two times in Postman select query will run only once, but if you restart the server again the select query will run. this is the problem in in-memory cache therefore we will use redis.
	
	
    public Product updateProduct(@RequestBody Product p) {
        return service.updateProduct(p);
    }
	
	@DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
        return "Product deleted successfully";
    }
}
