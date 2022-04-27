package com.example.projectmanager.factory.impl;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.entity.Retailer;
import com.example.projectmanager.entity.role.RetName;
import com.example.projectmanager.factory.RandomProductFactory;
import com.example.projectmanager.service.RetailerInterface;
import com.example.projectmanager.service.impl.ProductService;
import com.example.projectmanager.service.impl.RetailerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomProductFactoryImpl implements RandomProductFactory {

    @Autowired
    public RandomProductFactoryImpl(RetailerInterface retailerService) {
        this.retailerService = retailerService;
    }

    private final RetailerInterface retailerService;

    @Override
    public Product createRandomProduct() {
        return generateProductParameters();
    }

    private Product generateProductParameters() {
        Product product = new Product();
        Random randomGeneration = new Random();
        char letter1 = (char) (randomGeneration.nextInt(26) + 'a');
        char letter2 = (char) (randomGeneration.nextInt(26) + 'a');
        char letter3 = (char) (randomGeneration.nextInt(26) + 'a');
        int number = randomGeneration.nextInt(1000);
        if (number % 2 == 0) {
            product.getRetailers().add(retailerService.getRetailer(RetName.RET_A));
        } else {
            product.getRetailers().add(retailerService.getRetailer(RetName.RET_B));
        }
        product.setTitle("Title: " + "Product_" + letter1 + letter2);
        product.setDescription("Description: " + letter3 + number);
        product.setStockLevel(1L);
        return product;
    }
}