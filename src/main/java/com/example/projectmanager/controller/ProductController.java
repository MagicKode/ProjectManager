package com.example.projectmanager.controller;

import com.example.projectmanager.model.dto.ProductDto;
import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RequestMapping("/products/")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(path = "insert/{quantity}")
    public ResponseEntity<Void> insertRandomProducts(@PathVariable Integer quantity) {
        productService.insertRandomProducts(quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "increment")
    public ResponseEntity<Void> incrementStockLevelByRetailer(@RequestParam String name) {
        productService.incrementStockLevelByRetailerName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "search")
    public ResponseEntity<List<ProductDto>> findByKeyWord(@RequestParam String keyword) {
        return new ResponseEntity<>(productService.findByKeyWord(keyword), HttpStatus.OK);
    }

    @GetMapping(path = "blogPageable")
    public ResponseEntity<List<ProductDto>> blogPageable(Pageable pageable) {
        return new ResponseEntity<>(productService.blogPageable(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody Product product) {
        return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody Product product) {
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
    }

    @GetMapping("feign/")
    public ResponseEntity<ProductDto> getParams(
            @RequestParam String retailerName,
            @RequestParam Long stockLevel,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate
    ) {
        System.out.println(123);
        return null;
    }
}
