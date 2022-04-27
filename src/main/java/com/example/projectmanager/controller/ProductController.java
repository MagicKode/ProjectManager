package com.example.projectmanager.controller;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.entity.Retailer;
import com.example.projectmanager.repository.ProductRepository;
import com.example.projectmanager.repository.RetailerRepository;
import com.example.projectmanager.service.impl.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private ProductRepository productRepository;
    private RetailerRepository retailerRepository;

    @GetMapping(path = "add/20")
    public List<Product> insertTwentyRandomProducts() {
        return productService.insertRandomProducts();
    }

    /*@PostMapping(path = "/{name}")
    public void generateProductByRetailer(@PathVariable String name) {
        productService.generateProductByRetailer(name);
    }
*/
     /*@PostMapping (path = "/get/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
*/


}
