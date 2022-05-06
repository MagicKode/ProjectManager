package com.example.projectmanager.factory.impl;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.entity.Retailer;
import com.example.projectmanager.entity.retName.RetailerName;
import com.example.projectmanager.repository.RetailerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RandomProductFactoryImplTest {

    @Mock
    RetailerRepository retailerRepository;

    @InjectMocks
    private RandomProductFactoryImpl testSubject;

    Product product;
    Retailer retailer;

    @BeforeEach
    void init() {
        product = new Product();
        retailer = new Retailer();
        retailer.setName(RetailerName.RET_A.name());
        retailer.setName(RetailerName.RET_B.name());


        retailerRepository.save(retailer);
    }

    @Test
    void createRandomProduct() {
        //given
        Retailer retailer = new Retailer();
        Set<Retailer> retailers = new HashSet<>();
        retailer.setName(RetailerName.RET_A.name());
        retailer.setName(RetailerName.RET_B.name());
        retailers.add(retailer);
        retailerRepository.saveAll(retailers);
        when(retailerRepository.findByName(retailer.getName())).thenReturn(retailer);

        //when
        testSubject.createRandomProduct();

        //then
        assertNotNull(retailer);
        verify(retailerRepository, times(1)).findByName(retailer.getName());
    }
}