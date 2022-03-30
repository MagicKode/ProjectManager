package com.example.projectmanager.service.impl;

import com.example.projectmanager.entity.Retailer;

import java.util.List;

public interface RetailerInterface {

    boolean createRetailer(Retailer retailer);

    List<Retailer> getAllRetailers();

    Retailer getRetailerByName(String name);

    Retailer getRetailerById(Long id);

    void deleteRetailerById(Long id);

    void deleteAllRetailers();
}
