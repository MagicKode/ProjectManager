package com.example.projectmanager.controller;

import com.example.projectmanager.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
