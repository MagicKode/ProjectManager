package com.example.projectmanager.controller;

import com.example.projectmanager.model.dto.ProductDto;
import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.model.entity.enums.RetailerName;
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

import java.time.LocalDateTime;
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
    public ResponseEntity<Void> incrementStockLevelByRetailer(@RequestParam RetailerName name) {
        productService.incrementStockLevelByRetailerName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "search")
    public ResponseEntity<List<ProductDto>> findByKeyWord(@RequestParam String keyword) {
        return new ResponseEntity<>(productService.findByKeyWord(keyword), HttpStatus.OK);
    }

    @GetMapping(path = "pageable")
    public ResponseEntity<List<ProductDto>> findPageable(Pageable pageable) {
        return new ResponseEntity<>(productService.findPageable(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
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

    @GetMapping(path = "findByStockLevelGreaterThanEqualAndRetNameAndDateBetweenCreatedAtDates")
    public ResponseEntity<List<ProductDto>> getParams(
            RetailerName retailerName,
            Long minStockLevel,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate
    ) {
        return new ResponseEntity<>(
                productService.findByParams(minStockLevel, retailerName, startDate, endDate), HttpStatus.OK);
    }

    @GetMapping(path = "getQuantityOfProductByRetNameAndDateBetweenCreatedAtDates")
    public ResponseEntity<Long> getQuantity(
            RetailerName retailerName,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate
    ) {
        return new ResponseEntity<>(
                productService.getQuantityOfProducts(retailerName, startDate, endDate), HttpStatus.OK);
    }
}
