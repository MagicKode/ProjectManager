package com.example.projectmanager.service;

import com.example.projectmanager.entity.Product;

import java.util.List;

public interface ProductInterface {

    List<Product> createRandomProducts();

    void insertRandomProductEveryFiveMinutes();

    void generateProductByRetailer(String name);
}
