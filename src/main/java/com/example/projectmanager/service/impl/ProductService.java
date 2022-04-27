package com.example.projectmanager.service.impl;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.entity.role.RetName;
import com.example.projectmanager.factory.impl.RandomProductFactoryImpl;
import com.example.projectmanager.repository.ProductRepository;
import com.example.projectmanager.service.ProductInterface;
import com.example.projectmanager.service.schedule.GeneratedProductJob;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@Slf4j
@AllArgsConstructor
public class ProductService implements ProductInterface {

    private final ProductRepository productRepository;
    private RandomProductFactoryImpl productServiceFactory;
    private final GeneratedProductJob productJob;


    @Override
    @Transactional
    public List<Product> insertRandomProducts() {

       /* List<Product> products =
                Stream.of()
                .limit(20)
                .filter(product -> productServiceFactory.createRandomProduct())
                .collect(Collectors.toList());
        return productRepository.saveAll(products);*/

        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            products.add(productServiceFactory.createRandomProduct());
        }
        log.info("created products = {}", products);
        return productRepository.saveAll(products);
    }

    @Override
    @Transactional
    public void insertRandomProductEveryFiveMinutes() {
        productJob.productScheduler();
    }

   /* @Override
    @Transactional
    public void generateProductByRetailer(String name) {
        String name1 = String.valueOf(RetName.RET_A);
        String name2 = String.valueOf(RetName.RET_B);
        if (name.equals(name1)) {

        } else if (name.equals(name2)) {

        }
    }*/
}
