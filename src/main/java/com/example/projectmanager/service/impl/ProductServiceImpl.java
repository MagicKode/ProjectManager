package com.example.projectmanager.service.impl;

import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.model.entity.retName.RetailerName;
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
        if (RetailerName.RET_A.name().equals(name)) {
            productRepository.incrementStockLevel(5, name);
        } else if (RetailerName.RET_B.name().equals(name)) {
            productRepository.incrementStockLevel(8, name);
        }
    }

    @Override
    @Transactional
    public List<Product> findByKeyWord(String keyword) {
        return productRepository.findAll("%" + keyword + "%");
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
