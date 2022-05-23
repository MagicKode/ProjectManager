package com.example.projectmanager.service;

import com.example.projectmanager.exception.NotFoundException;
import com.example.projectmanager.model.dto.ProductDto;
import com.example.projectmanager.model.entity.Product;

import java.util.List;

public interface ProductService {

    void insertRandomProducts(Integer quantity);
    void incrementStockLevelByRetailerName(String name);
    void deleteById(Long id) throws NotFoundException;

    ProductDto findById(Long id);
    ProductDto update(Product product);
    Product create(Product product);

    List<ProductDto> findByKeyWord(String keyword);
    List<ProductDto> findAll();
}
