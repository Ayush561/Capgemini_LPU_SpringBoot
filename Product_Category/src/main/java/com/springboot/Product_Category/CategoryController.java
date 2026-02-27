package com.springboot.Product_Category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    @PostMapping("/add")
    public Category add(@RequestBody Category c) {
        return service.addCategory(c);
    }

    @GetMapping("/find-id/{id}")
    public String findById(@PathVariable int id) {
        Optional<Category> option = service.findById(id);
        return option.isPresent() ? option.get().toString() : "Data not found";
    }

    @PatchMapping("/update-id/{id}")
    public String update(@PathVariable int id, @RequestBody Category c) {
        Category updated = service.updateCategory(id, c);
        return updated != null ? "Category Updated" : "Data not found";
    }

    @DeleteMapping("/delete-id/{id}")
    public String delete(@PathVariable int id) {
        return service.deleteById(id) ? "Deleted" : "Data not found";
    }
}