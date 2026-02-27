package com.springboot.Product_Category;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;
    private double price;

    @ManyToOne
    private Category category;

    public Product() {}

    public Product(String productName, double price, Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String toString() {
        return "Product [id=" + productId + ", name=" + productName + ", price=" + price +
                ", category=" + (category != null ? category.getCategoryName() : "null") + "]";
    }
}