package com.example.projectmanager.service;

import com.example.projectmanager.model.dto.ProductDto;
import com.example.projectmanager.model.entity.Product;

import java.util.List;

public interface ProductService {

    void insertRandomProducts(Integer quantity);
    void incrementStockLevelByRetailerName(String name);
    void deleteProductById(Long id);

    ProductDto getById(Long id);
    ProductDto update(Product product);
    Product create(Product product);

    List<ProductDto> findByKeyWord(String keyword);
    List<ProductDto> findAllProducts();
}
