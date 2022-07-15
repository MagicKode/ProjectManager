package com.example.projectmanager.mapper;

import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.model.dto.ProductDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(uses = RetailerMapper.class)
public interface ProductMapper {
    ProductDto toProductDto(Product product);
    List<ProductDto> toListProductDto(List<Product> products);

    @Named("toProductDtoWithoutRetailers")
    @Mapping(target = "retailers", ignore = true)
    ProductDto toProductDtoWithoutRetailers(Product product);

    @IterableMapping(qualifiedByName = "toProductDtoWithoutRetailers")
    List<ProductDto> toListProductDtoWithoutRetailers(List<Product> products);
}
