package com.example.projectmanager.controller;

import com.example.projectmanager.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products")
@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(path = "/insert/{quantity}")
    public void insertRandomProducts(@PathVariable Integer quantity) {
        productService.insertRandomProducts(quantity);
    }

    @PostMapping(path = "/increment")
    public void incrementStockLevelByRetailer(@RequestParam String name) {
        productService.incrementStockLevelByRetailerName(name);
    }
}
