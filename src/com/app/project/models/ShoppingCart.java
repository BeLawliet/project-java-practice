package com.app.project.models;

import java.util.Map;
import java.util.Set;

public class ShoppingCart {
    private Integer buyNumber;
    private Map<Set<Product>, Integer> products;
    private Double subTotal;
    private Double total;
    private static int lastId;

    public ShoppingCart() {
        this.buyNumber = ++lastId;
    }

    public ShoppingCart(Map<Set<Product>, Integer> products, Double subTotal, Double total) {
        this();
        this.products = products;
        this.subTotal = subTotal;
        this.total = total;
    }

    public Integer getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }

    public Map<Set<Product>, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Set<Product>, Integer> products) {
        this.products = products;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ShoppingCart = { Buy Number: " + buyNumber + ", Products: " + products + ", SubTotal: " + subTotal + ", Total: " + total + " }";
    }
}
