package com.example.projectmanager.factory.impl;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.factory.RandomProductFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomProductFactoryImpl implements RandomProductFactory {

    @Override
    public Product generateRandomProduct(Product product) {
        Random randomCreation = new Random();
        char letter = (char) (randomCreation.nextInt(26) + 'a');
        int number = randomCreation.nextInt(100);
        product.setTitle("Title: " + "Product_" + letter);
        product.setStockLevel("StockLevel: " + number);
        product.setDescription("Description: " + letter + number);
        return product;
    }


  /*  private String generateProductParameters() {
        Random randomCreation = new Random();
        char letter = (char) (randomCreation.nextInt(26) + 'a');
        int number = randomCreation.nextInt(100);
        title = "Product_" + letter;
        stockLevel = "StockLevel: " + number;
        description = "Description: " + letter + number;
        return;
    }
*/

}
