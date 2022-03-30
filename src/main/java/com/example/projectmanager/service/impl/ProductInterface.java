package com.example.projectmanager.service.impl;

import com.example.projectmanager.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductInterface {

    void saveProduct(Product product);

    Product updateProduct(String title, int price, String description, Long stockLevel);

    Product getProductById(long id);

    List<Product> getAllProducts();

    void deleteProductById(long id);

    void deleteAllProducts();



}
