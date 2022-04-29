package com.example.projectmanager.service;

public interface ProductService {

    void insertRandomProducts(Integer quantity);

    void insertRandomProductEveryFiveMinutes();

    void incrementStockLevelByRetailer(String name);

    void updateParameter(Long stockLevel, Long id);
}
