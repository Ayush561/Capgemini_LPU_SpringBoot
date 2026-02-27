package com.springboot.Product_Category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductJPARepository productRepo;

    @Autowired
    CategoryJPARepository categoryRepo;

    public Product addProduct(Product p, int categoryId) {
        Optional<Category> option = categoryRepo.findById(categoryId);
        if (option.isPresent()) {
            p.setCategory(option.get());
            return productRepo.save(p);
        }
        return null;
    }

    public Optional<Product> findById(int id) {
        return productRepo.findById(id);
    }

    public List<Product> findByName(String name) {
        return productRepo.findByProductName(name);
    }

    public List<Product> findByCategoryId(int categoryId) {
        return productRepo.findByCategoryCategoryId(categoryId);
    }

    public Product updateProduct(int id, Product p) {
        Optional<Product> option = productRepo.findById(id);
        if (option.isPresent()) {
            Product prod = option.get();
            if (p.getProductName() != null) {
                prod.setProductName(p.getProductName());
            }
            if (p.getPrice() != 0.0) {
                prod.setPrice(p.getPrice());
            }
            return productRepo.save(prod);
        }
        return null;
    }

    public boolean deleteById(int id) {
        Optional<Product> option = productRepo.findById(id);
        if (option.isPresent()) {
            productRepo.delete(option.get());
            return true;
        }
        return false;
    }
}