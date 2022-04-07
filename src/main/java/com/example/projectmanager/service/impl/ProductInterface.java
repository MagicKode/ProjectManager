package com.example.projectmanager.service.impl;

import com.example.projectmanager.entity.Product;

import java.util.List;

public interface ProductInterface {

    void saveProduct(Product product);

    Product getProductById(long id);

    List<Product> getAllProducts();

    void deleteProductById(long id);

    void deleteAllProducts();



}
