package com.capgemini.Assignment2_26thfeb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.Assignment2_26thfeb.dao.CategoryJpaRepository;
import com.capgemini.Assignment2_26thfeb.dao.ProductJpaRepository;
import com.capgemini.Assignment2_26thfeb.dto.Category;
import com.capgemini.Assignment2_26thfeb.dto.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
	private ProductJpaRepository productRepo;
	private CategoryJpaRepository categoryRepo;

	public ProductController(ProductJpaRepository productRepo, CategoryJpaRepository categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}

	@PostMapping("/{categoryId}")
	public Product createProduct(@RequestBody Product product, @PathVariable int categoryId) {
		 System.out.println("Inside createProduct");
		Category category = categoryRepo.findById(categoryId).get();
		product.setCategory(category);

		return productRepo.save(product);
	}

	@GetMapping("/getproduct")
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@GetMapping("view/{id}")
	public Optional<Product> getProduct(@PathVariable int id) {
		return productRepo.findById(id);
	}

	@PutMapping("update/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product newProduct) {

		Product product = productRepo.findById(id).get();

		product.setProductName(newProduct.getProductName());
		product.setPrice(newProduct.getPrice());

		return productRepo.save(product);
	}

	@DeleteMapping("delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		productRepo.deleteById(id);
		return "Product Deleted Successfully";
	}

	@GetMapping("/category/{categoryId}")
	public List<Product> getProductsByCategory(@PathVariable int categoryId) {
		return productRepo.findByCategory_CategoryId(categoryId);
	}

	@GetMapping("/search")
	public List<Product> searchProduct(@RequestParam String name) {
		return productRepo.findByProductName(name);
	}

}
