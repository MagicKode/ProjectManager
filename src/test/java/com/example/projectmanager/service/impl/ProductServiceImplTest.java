package com.example.projectmanager.service.impl;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.entity.Retailer;
import com.example.projectmanager.entity.retName.RetailerName;
import com.example.projectmanager.factory.impl.RandomProductFactoryImpl;
import com.example.projectmanager.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @Mock
    RandomProductFactoryImpl randomProductFactory;

    @InjectMocks
    ProductServiceImpl testSubject;

    Retailer retailer;
    List<Product> products;

    @BeforeEach
    void init() {
        retailer = new Retailer();
        products = new ArrayList<>();
    }

    @Test
    void shouldInsertRandomProducts() {
        //given
        List<Product> products = IntStream
                .range(0, 4)
                .mapToObj(i -> randomProductFactory.createRandomProduct())
                .collect(Collectors.toList());
        when(productRepository.saveAll(products)).thenReturn(products);

        //when
        testSubject.insertRandomProducts(4);

        //then
        assertNotNull(products);
        verify(productRepository, times(1)).saveAll(products);
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