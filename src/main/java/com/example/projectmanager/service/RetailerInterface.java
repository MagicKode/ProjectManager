package com.example.projectmanager.service;

import com.example.projectmanager.entity.Retailer;
import com.example.projectmanager.entity.role.RetName;

public interface RetailerInterface {

    Retailer getRetailer(RetName retName);
}
