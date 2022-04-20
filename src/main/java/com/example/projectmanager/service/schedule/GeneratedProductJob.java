package com.example.projectmanager.service.schedule;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.factory.impl.RandomProductFactoryImpl;
import com.example.projectmanager.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class GeneratedProductJob {

    private ProductRepository productRepository;
    private RandomProductFactoryImpl randomProductFactory;
    private static final Logger log = LoggerFactory.getLogger(GeneratedProductJob.class);

    @Scheduled(fixedRate = 3_000)
    public void createRandomProductsEveryFiveMinutes() {
        Product product = new Product();
        Product[] products = new Product[3];

        products[0] =  randomProductFactory.generateRandomProduct(product);
        log.info("Created product1 = {}", products[0]);
        productRepository.save(products[0]);

        products[1] = randomProductFactory.generateRandomProduct(product);
        log.info("Created product2 = {}", products[1]);
        productRepository.save(products[1]);

        products[2] = randomProductFactory.generateRandomProduct(product);
        log.info("Created product3 = {}", products[2]);
        productRepository.save(products[2]);

    }
}
