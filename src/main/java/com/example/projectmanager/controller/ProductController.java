package com.example.projectmanager.controller;

import com.example.projectmanager.model.dto.ProductDto;
import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(path = "/insert/{quantity}")
    public ResponseEntity<Void> insertRandomProducts(@PathVariable Integer quantity) {
        productService.insertRandomProducts(quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/increment")
    public ResponseEntity<Void> incrementStockLevelByRetailer(@RequestParam String name) {
        productService.incrementStockLevelByRetailerName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<ProductDto>> findProductByKeyWord(@RequestParam String keyword) {
        List<ProductDto> productsDto = productService.findByKeyWord(keyword);
        if (productsDto != null) {
            return new ResponseEntity<>(productsDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        List<ProductDto> productsDto = productService.findAllProducts();
        if (productsDto.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(productsDto, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        ProductDto productDto = productService.getById(id);
        if (productDto != null) {
            return new ResponseEntity<>(productDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No product found with such id", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/")
    public ResponseEntity<ProductDto> update(@RequestBody Product product) {
        ProductDto productsDto = productService.update(product);
        return new ResponseEntity<>(productsDto, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product createProduct = productService.create(product);
        return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
    }
}
