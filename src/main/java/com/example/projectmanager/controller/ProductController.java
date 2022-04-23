package com.example.projectmanager.controller;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.service.impl.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(path = "/add20")
    public List<Product> addProductByUser(Product product){
        return productService.createSomeRandomProducts(product);
    }


    /*@PostMapping(path = "/{name}")
    public Product saveProductByRetailer(@PathVariable String name, Product product){
        return productService.saveProductByRetailers(product);
    }

    @PostMapping (path = "/get/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
*/



}
