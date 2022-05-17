package com.example.projectmanager.mapper;

import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.model.dto.ProductDto;

import java.util.List;

public interface ProductMapper {

    ProductDto toProductDto(Product product);

    List<ProductDto> toListProductDto(List<Product> products);

    ProductDto toProductDTOWithRetailerDto(Product product);

    List<ProductDto> toListProductWithRetailerDto(List<Product> products);
}
