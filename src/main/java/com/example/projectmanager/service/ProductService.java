package com.example.projectmanager.service;

public interface ProductService {

    void insertRandomProducts(Integer quantity);

    void incrementStockLevel(String name);
}
