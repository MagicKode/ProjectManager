package com.example.projectmanager.service;

import com.example.projectmanager.model.dto.ProductDto;
import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.model.entity.enums.RetailerName;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductService {
    void insertRandomProducts(Integer quantity);
    void incrementStockLevelByRetailerName(RetailerName name);
    void deleteById(Long id);

    List<ProductDto> findPageable(Pageable pageable);
    List<ProductDto> findByKeyWord(String keyword);
    List<ProductDto> findByParams(
            Long minStockLevel,
            RetailerName retailerName,
            LocalDateTime startDate,
            LocalDateTime endDate
    );

    ProductDto findById(Long id);
    ProductDto update(Product product);
    ProductDto create(Product product);

    Long getQuantityOfProducts(RetailerName retailerName, LocalDateTime startDate, LocalDateTime endDate);
}
