package com.example.projectmanager.service.factory;

import java.util.Random;

public class ProductFactory {

    // creation of Product PARAMETERS

    public String createProductTitle() {
        //title
        String title;
        Random r = new Random();
        char letter = (char) (r.nextInt(26) + 'a');
        return title = "Product_" + letter;
    }

    public String createProductStockLevel() {
        //stockLevel
        String stockLevel;
        Random r = new Random();
        int num = r.nextInt(100);
        return stockLevel = "StockLevel: " + num;
    }

    public String createProductDescription() {

        //letters creation
        Random r = new Random();
        char letter = (char) (r.nextInt(26) + 'a');

        //numbers creation
        String description;
        int n = 100;
        Random r1 = new Random();
        int num = r1.nextInt(n);

        return description = "Description: " + letter + "" + num;
    }
}
