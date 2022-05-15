package com.example.projectmanager.controller;

import com.example.projectmanager.model.dto.ProductDto;
import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.mapper.ProductMapper;
import com.example.projectmanager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        List<Product> findByKeyWord = productService.findByKeyWord(keyword);
        return productMapper.toListProductDto(findByKeyWord);
    }

    @GetMapping(path = "/")
    public List<ProductDto> findAllProducts(){
        List<Product> findAll = productService.findAll();
        return productMapper.toListProductDto(findAll);
    }
}
