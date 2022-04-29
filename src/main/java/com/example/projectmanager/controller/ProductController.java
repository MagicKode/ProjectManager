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
    public void insertRandomProducts(@PathVariable String quantity) {
        productService.insertRandomProducts(Integer.valueOf(quantity));
    }

    @PutMapping(path = "/{name}")
    public void incrementStockLevelByRetailer(@PathVariable String name) {
        productService.incrementStockLevelByRetailer(name);
    }
}
