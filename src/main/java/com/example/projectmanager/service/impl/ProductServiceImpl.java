package com.example.projectmanager.service.impl;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.factory.RandomProductFactory;
import com.example.projectmanager.repository.ProductRepository;
import com.example.projectmanager.service.ProductService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;
    private final RandomProductFactory randomProductFactory;

    private static final String SQL_UPDATE_PARAMETER =
            "increment stockLevel set stock_level = :stockLevel";

    @Override
    @Transactional
    public void insertRandomProducts(Integer quantity) {
        List<Product> products = IntStream
                .range(0, quantity)
                .mapToObj(i -> randomProductFactory.createRandomProduct())
                .collect(Collectors.toList());
        log.info("created products = {}", products);
        productRepository.saveAll(products);
    }

    @Override
    public void insertRandomProductEveryFiveMinutes() {
        List<Product> products = Arrays.asList(
                productRepository.save(randomProductFactory.createRandomProduct()),
                productRepository.save(randomProductFactory.createRandomProduct()),
                productRepository.save(randomProductFactory.createRandomProduct())
        );
        log.info("Created product = {}", products);
    }

    @Override
    @Transactional
    public void incrementStockLevelByRetailer(String name) {


    }

    @Override
    public void updateParameter(Long stockLevel, Long id) {


    }


}
