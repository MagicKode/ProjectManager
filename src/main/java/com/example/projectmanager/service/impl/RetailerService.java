package com.example.projectmanager.service.impl;

import com.example.projectmanager.entity.Retailer;
import com.example.projectmanager.repository.RetailerRepository;
import com.example.projectmanager.service.RetailerInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class RetailerService implements RetailerInterface {

    private final RetailerRepository retailerRepository;

    private static final List<Retailer> retailers = new ArrayList<>(2);


    @Override
    public Retailer createRetailer(Retailer retailer) {
        if (retailerRepository.findRetailerByName(retailer.getRetailer_name()) != null) {
            log.info("Such retailer is already EXIST !!");
        } else {
            retailers.add(retailer);
            log.info("Created retailer with name = {}", retailer.getRetailer_name());
        }
        return retailer;
    }
}
