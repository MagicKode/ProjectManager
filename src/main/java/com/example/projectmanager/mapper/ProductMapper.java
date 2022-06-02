package com.example.projectmanager.mapper;

import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.model.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Mapping(target = "retailers", ignore = true)
    ProductDto toProductDto(Product product);
    List<ProductDto> toListProductDto(List<Product> products);
    List<ProductDto> toListProductDto(Page<Product> products);
}
