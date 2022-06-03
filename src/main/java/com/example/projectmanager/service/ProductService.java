package com.example.projectmanager.service;

import com.example.projectmanager.model.dto.ProductDto;
import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.model.entity.Retailer;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {

    void insertRandomProducts(Integer quantity);
    void incrementStockLevelByRetailerName(String name);
    void deleteById(Long id);

    List<ProductDto> blogPageable(Pageable pageable);
    List<ProductDto> findByKeyWord(String keyword);

    ProductDto findById(Long id);
    ProductDto update(Product product);
    ProductDto create(Product product);
    List<ProductDto> findParamsOfProductFoundByStockLevelRetailerStartDateEndDate(Long stockLevel, String retailer, LocalDate startDate, LocalDate endDate);
}
