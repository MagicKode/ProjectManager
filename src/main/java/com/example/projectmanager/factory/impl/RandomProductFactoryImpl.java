package com.example.projectmanager.factory.impl;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.factory.RandomProductFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomProductFactoryImpl implements RandomProductFactory {

    @Override
    public Product createRandomProduct() {
        return generateProductParameters();
    }

    private Product generateProductParameters() {
        Product product = new Product();
        Random randomCreation = new Random();
        char letter1 = (char) (randomCreation.nextInt(26) + 'a');
        char letter2 = (char) (randomCreation.nextInt(26) + 'a');
        char letter3 = (char) (randomCreation.nextInt(26) + 'a');
        int number1 = randomCreation.nextInt(1000);
        int number2 = randomCreation.nextInt(1000);
        product.setTitle("Title: " + "Product_" + letter1 + letter2);
        product.setDescription("Description: " + letter3 + number1);
        product.setStockLevel("StockLevel: " + number2);
        return product;
    }
}