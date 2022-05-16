package com.example.projectmanager.service;

import com.example.projectmanager.model.entity.Product;
import java.util.List;

public interface ProductService {

    void insertRandomProducts(Integer quantity);
    void incrementStockLevelByRetailerName(String name);

    List<Product> findByKeyWord(String keyword);
    List<Product> findAllProducts();
}
