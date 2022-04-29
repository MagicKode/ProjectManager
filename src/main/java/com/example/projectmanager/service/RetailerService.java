package com.example.projectmanager.service;

import com.example.projectmanager.entity.Retailer;
import com.example.projectmanager.entity.retName.RetailerName;

public interface RetailerService {
    Retailer getRetailer(RetailerName retailerName);
}
