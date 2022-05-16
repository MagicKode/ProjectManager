package com.example.projectmanager.factory.impl;

import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.model.entity.enums.RetailerName;
import com.example.projectmanager.factory.RandomProductFactory;
import com.example.projectmanager.repository.RetailerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@RequiredArgsConstructor
@Component
public class RandomProductFactoryImpl implements RandomProductFactory {

    private final RetailerRepository retailerRepository;

    @Override
    public Product createRandomProduct() {
        Product product = new Product();
        Random randomGeneration = new Random();
        char letter1 = (char) (randomGeneration.nextInt(26) + 'a');
        char letter2 = (char) (randomGeneration.nextInt(26) + 'a');
        char letter3 = (char) (randomGeneration.nextInt(26) + 'a');
        char letter4 = (char) (randomGeneration.nextInt(26) + 'a');
        char letter5 = (char) (randomGeneration.nextInt(26) + 'a');
        int number = randomGeneration.nextInt(1000);
        if (number % 2 == 0) {
            product.getRetailers().add(retailerRepository.findByName(RetailerName.RET_A.name()));
        } else {
            product.getRetailers().add(retailerRepository.findByName(RetailerName.RET_B.name()));
        }
        product.getRetailers().forEach(retailer -> retailer.getProducts().add(product));
        product.setTitle("Title: " + "Product_" + letter1 + letter2 + letter3);
        product.setDescription("Description: " + letter4 + letter5 + number);
        product.setStockLevel(1L);
        return product;
    }
}
