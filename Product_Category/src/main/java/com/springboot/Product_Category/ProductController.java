package com.springboot.Product_Category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/add/{categoryId}")
    public Product add(@PathVariable int categoryId, @RequestBody Product p) {
        return service.addProduct(p, categoryId);
    }

    @GetMapping("/find-id/{id}")
    public String findById(@PathVariable int id) {
        Optional<Product> option = service.findById(id);
        return option.isPresent() ? option.get().toString() : "Data not found";
    }

    @GetMapping("/find-by-name/{name}")
    public List<Product> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/find-by-category/{categoryId}")
    public List<Product> findByCategory(@PathVariable int categoryId) {
        return service.findByCategoryId(categoryId);
    }

    @PatchMapping("/update-id/{id}")
    public String update(@PathVariable int id, @RequestBody Product p) {
        Product updated = service.updateProduct(id, p);
        return updated != null ? "Product Updated" : "Data not found";
    }

    @DeleteMapping("/delete-id/{id}")
    public String delete(@PathVariable int id) {
        return service.deleteById(id) ? "Deleted" : "Data not found";
    }
}