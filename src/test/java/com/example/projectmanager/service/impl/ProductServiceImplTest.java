package com.example.projectmanager.service.impl;

import com.example.projectmanager.entity.retName.RetailerName;
import com.example.projectmanager.factory.impl.RandomProductFactoryImpl;
import com.example.projectmanager.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @Mock
    RandomProductFactoryImpl randomProductFactory;

    @InjectMocks
    ProductServiceImpl testSubject;

    @Test
    void shouldInsertRandomProducts() {
        //when
        testSubject.insertRandomProducts(4);

        //then
        verify(productRepository, times(1)).saveAll(Mockito.anyList());
        verify(randomProductFactory, times(4)).createRandomProduct();
    }

    @Test
    void shouldIncrementStockLevelByRetailerNameA() {
        //given
        String name = RetailerName.RET_A.name();

        //when
        testSubject.incrementStockLevelByRetailerName(name);

        //then
        verify(productRepository, times(1)).incrementStockLevel(5, name);
    }

    @Test
    void shouldIncrementStockLevelByRetailerNameB() {
        //given
        String name = RetailerName.RET_B.name();

        //when
        testSubject.incrementStockLevelByRetailerName(name);

        //then
        verify(productRepository, times(1)).incrementStockLevel(8, name);
    }
}
