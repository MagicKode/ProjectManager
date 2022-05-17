package com.example.projectmanager.mapper.impl;

import com.example.projectmanager.mapper.RetailerMapper;
import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.model.dto.ProductDto;
import com.example.projectmanager.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapperImpl implements ProductMapper {

    private final RetailerMapper retailerMapper;

    @Override
    public ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setStockLevel(product.getStockLevel());
        return productDto;
    }

    @Override
    public List<ProductDto> toListProductDto(List<Product> products){
        return products.stream().map(this::toProductDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto toProductDTOWithRetailerDto(Product product) {
        ProductDto productDto = toProductDto(product);
        productDto.setRetailers(retailerMapper.toSetRetailerDto(product.getRetailers()));
        return productDto;
    }

    @Override
    public List<ProductDto> toListProductWithRetailerDto(List<Product> products){
        return products.stream().map(this::toProductDto).collect(Collectors.toList());
    }
}
