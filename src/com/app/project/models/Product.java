package com.app.project.models;

import java.util.Set;

public class Product implements Comparable<Product> {
    private Integer productId;
    private Long productCode;
    private String productName;
    private Double price;
    private int amount;
    private Set<Category> categories;
    private static int lastId;

    public Product() {
        this.productId = ++lastId;
    }

    public Product(Long productCode, String productName, Double price, int amount) {
        this();
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
    }

    public Product(Long productCode, String productName, Double price, int amount, Set<Category> categories) {
        this(productCode, productName, price, amount);
        this.categories = categories;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void showProducts() {
        System.out.println("Product = { Id: " + productId + ", Code: " + productCode + ", Name: '" + productName + "', Price: " + price + ", Categories: " + categories + " }");
    }

    @Override
    public String toString() {
        return productName + ", " + price + ", Stock: " + this.amount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        Product other = (Product) obj;
        if (productId == null) {
            if (other.productId != null) return false;
        } else if (!productId.equals(other.productId)) return false;

        return true;
    }

    @Override
    public int compareTo(Product o) {
        if (this.productId == null) return 0;
        return this.productId.compareTo(o.productId);
    }
}
