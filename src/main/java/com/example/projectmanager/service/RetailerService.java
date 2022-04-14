package com.example.projectmanager.service;

import com.example.projectmanager.entity.role.Retailer;
import com.example.projectmanager.repository.RetailerRepository;
import com.example.projectmanager.service.impl.RetailerInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.projectmanager.entity.role.RetName.RET_A;
import static com.example.projectmanager.entity.role.RetName.RET_B;


@Service
@Slf4j
@RequiredArgsConstructor
public class RetailerService implements RetailerInterface {

    private final RetailerRepository retailerRepository;


    @Override
    public boolean createRetailer(Retailer retailer) {
        if (retailerRepository.findRetailerByName(retailer.getName()) != null) {
            return false;
        } else {


            log.info("Created user with name = {}", retailer.getName());
        }
        return true;
    }

    public createRetailer(Retailer retailer) {
        List<Retailer> retailers = new ArrayList<>(); //поменять тип переменной на List
        retailer.setName(String.valueOf(RET_A));
        retailer.setName(String.valueOf(RET_B));
        retailers.add(retailer);
        return retailer;
    }

    static {
        String name = "lkm;lk";
        String name1 = "lkm;lk";
    }




}
