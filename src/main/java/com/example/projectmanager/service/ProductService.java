package com.example.projectmanager.service;

public interface ProductService {

    void insertRandomProducts(Integer quantity);

    void incrementStockLevelByRetailerName(String name);
}
