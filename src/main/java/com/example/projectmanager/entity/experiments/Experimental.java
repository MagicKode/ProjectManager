package com.example.projectmanager.entity.experiments;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Experimental {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        while (true) {
            try {
                sleep(5000);
                System.out.println(scheduler.createStockLevel());
                System.out.println(scheduler.createStockLevel());
                System.out.println(scheduler.createStockLevel());
                System.out.println("__");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Scheduler {
    public String createStockLevel() {
        String stockLevel;
        Random r = new Random();
        int num = r.nextInt(100);
        stockLevel = "StockLevel: " + num;
        return stockLevel;
    }
}