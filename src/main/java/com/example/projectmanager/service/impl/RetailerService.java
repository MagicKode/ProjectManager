package com.example.projectmanager.service.impl;

import com.example.projectmanager.entity.Retailer;
import com.example.projectmanager.entity.role.RetName;
import com.example.projectmanager.repository.RetailerRepository;
import com.example.projectmanager.service.RetailerInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class RetailerService implements RetailerInterface {

    private final RetailerRepository retailerRepository;
    private static final List<Retailer> retailers = new ArrayList<>(2);

    @PostConstruct
    private void PostConstruct() {
        retailers.addAll(retailerRepository.findAll());
    }

    @Override
    public Retailer getRetailer(RetName retName) {
        List<Retailer> retailerList = retailerRepository.findAll();
        return retailers.stream()
                .filter(retailer -> retailer.getName().equals(retName.name()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Retailer not found with name " + retName));
    }
}