package com.example.projectmanager.controller;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(path = "/add")
    public Product addProductByUser(Product product){
        return productService.addProductByUser(product);
    }


    @PostMapping(path = "/Ret_/{}")
    public Product saveProductByRetailer(Product product){
        return productService.saveProductByRetailers(product);
    }

    @PostMapping (path = "/get/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping(path = "/get/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping(path = "/delete/{id}")
    public void deletePRoductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @GetMapping(path = "/delete/all")
    public void deleteAllProducts(){
        productService.deleteAllProducts();
    }



}
