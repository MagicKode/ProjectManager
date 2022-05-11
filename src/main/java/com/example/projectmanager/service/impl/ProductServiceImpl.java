package com.example.projectmanager.service.impl;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.factory.RandomProductFactory;
import com.example.projectmanager.repository.ProductRepository;
import com.example.projectmanager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.example.projectmanager.entity.retName.RetailerName.RET_A;
import static com.example.projectmanager.entity.retName.RetailerName.RET_B;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;
    private final RandomProductFactory randomProductFactory;

    @Override
    @Transactional
    public void insertRandomProducts(Integer quantity) {
        List<Product> products = IntStream
                .range(0, quantity)
                .mapToObj(i -> randomProductFactory.createRandomProduct())
                .collect(Collectors.toList());
        productRepository.saveAll(products);
        log.info("created products = {}", products);
    }

    @Override
    @Transactional
    public void incrementStockLevelByRetailerName(String name) {
        if (RET_A.name().equals(name)) {
            productRepository.incrementStockLevel(5, name);
        } else if (RET_B.name().equals(name)) {
            productRepository.incrementStockLevel(8, name);
        }
    }
}
