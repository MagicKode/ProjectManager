package com.example.projectmanager.controller;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(path = "/insert/{quantity}")
    public void insertRandomProducts(@PathVariable String quantity) {
        productService.insertRandomProducts(Integer.valueOf(quantity));
    }

    @PutMapping(path = "/")
    public void incrementStockLevelByRetailer(@RequestParam String name) {
        productService.incrementStockLevel(name);
    }
}
