package com.example.projectmanager.service.schedule;

import com.example.projectmanager.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class GeneratedProductJob {

    private final ProductService productService;

    @Scheduled(fixedRate = 60_000)
    @Transactional
    public void productScheduler() {
        productService.insertRandomProducts(3);
    }
}
