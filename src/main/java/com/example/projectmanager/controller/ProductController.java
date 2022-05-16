package com.example.projectmanager.controller;

import com.example.projectmanager.model.dto.ProductDto;
import com.example.projectmanager.mapper.ProductMapper;
import com.example.projectmanager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping(path = "/insert/{quantity}")
    public void insertRandomProducts(@PathVariable Integer quantity) {
        productService.insertRandomProducts(quantity);
    }

    @PostMapping(path = "/increment")
    public void incrementStockLevelByRetailer(@RequestParam String name) {
        productService.incrementStockLevelByRetailerName(name);
    }

    @GetMapping(path = "/{keyword}")
    public List<ProductDto> findProductByKeyWord(@PathVariable String keyword) {
        return productMapper.toListProductDto(productService.findByKeyWord(keyword));
    }

    @GetMapping(path = "/")
    public List<ProductDto> findAllProducts(){
        return productMapper.toListProductDto(productService.findAllProducts());
    }
}
