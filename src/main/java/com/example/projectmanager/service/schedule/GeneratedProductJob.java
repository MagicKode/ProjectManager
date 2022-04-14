package com.example.projectmanager.service.schedule;

import com.example.projectmanager.entity.Product;
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
    private static final Logger log = LoggerFactory.getLogger(GeneratedProductJob.class);

    @Scheduled(fixedRate = 300_000)
    public Product createProductAndReportCurrentTime(Product product) {
        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product);
        products.add(product);
        return productRepository.saveProduct(products);
    }
}
