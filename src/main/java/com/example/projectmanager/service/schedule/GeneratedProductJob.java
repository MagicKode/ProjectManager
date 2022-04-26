package com.example.projectmanager.service.schedule;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.factory.impl.RandomProductFactoryImpl;
import com.example.projectmanager.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@Service
@AllArgsConstructor
public class GeneratedProductJob {

    private ProductRepository productRepository;
    private static final Logger log = LoggerFactory.getLogger(GeneratedProductJob.class);
    private final RandomProductFactoryImpl randomProductFactory;

    @Scheduled(fixedRate = 30_000)
    @Transactional
    public void productScheduler() {
        List<Product> products = Arrays.asList(
                productRepository.save(createProduct()),
                productRepository.save(createProduct()),
                productRepository.save(createProduct())
        );
        log.info("Created product = {}", products);
    }

    private Product createProduct() {
        return randomProductFactory.createRandomProduct();
    }
}
