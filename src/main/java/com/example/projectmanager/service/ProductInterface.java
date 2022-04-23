package com.example.projectmanager.service;

import com.example.projectmanager.entity.Product;

import java.util.List;

public interface ProductInterface {

    List<Product> createSomeRandomProducts(Product product);

    void createRandomProductsEveryFiveMinutes();

}
