package com.example.projectmanager.service;

import com.example.projectmanager.model.dto.ProductDto;
import com.example.projectmanager.model.entity.Product;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductService {
    void insertRandomProducts(Integer quantity);
    void incrementStockLevelByRetailerName(String name);
    void deleteById(Long id);

    List<ProductDto> findPageable(Pageable pageable);
    List<ProductDto> findByKeyWord(String keyword);
    List<ProductDto> findByParams(Long stockLevel, String retailerName, LocalDateTime startDate, LocalDateTime endDate);

    ProductDto findById(Long id);
    ProductDto update(Product product);
    ProductDto create(Product product);
}
