package com.example.projectmanager.service.schedule;

import com.example.projectmanager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GeneratedProductJob {

    @Value("${product.quantity}")
    private Integer quantity;

    private final ProductService productService;

    @Scheduled(fixedDelayString = "${scheduler.interval}")
    @Transactional
    public void productScheduler() {
        productService.insertRandomProducts(quantity);
    }
}
