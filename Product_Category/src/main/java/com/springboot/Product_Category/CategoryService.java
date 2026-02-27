package com.springboot.Product_Category;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryJPARepository categoryRepo;

    public Category addCategory(Category c) {
        return categoryRepo.save(c);
    }

    public Optional<Category> findById(int id) {
        return categoryRepo.findById(id);
    }

    public Category updateCategory(int id, Category c) {
        Optional<Category> option = categoryRepo.findById(id);
        if (option.isPresent()) {
            Category cat = option.get();
            if (c.getCategoryName() != null) {
                cat.setCategoryName(c.getCategoryName());
            }
            if (c.getDescription() != null) {
                cat.setDescription(c.getDescription());
            }
            return categoryRepo.save(cat);
        }
        return null;
    }

    public boolean deleteById(int id) {
        Optional<Category> option = categoryRepo.findById(id);
        if (option.isPresent()) {
            categoryRepo.delete(option.get());
            return true;
        }
        return false;
    }
}