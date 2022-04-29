package com.example.projectmanager.service;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.repository.ProductRepository;
import com.example.projectmanager.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl testObject;

    Product product;

    @BeforeEach
    void init(){
        product = new Product();
        product.setId(1L);
        product.setTitle("Auto");
        product.setDescription("fast");
    }

    @Test
    void insertRandomProducts() {
        //given

        //when

        //then
    }

    @Test
    void insertRandomProductEveryFiveMinutes() {
    }

    @Test
    void findAll() {
    }

    @Test
    void incrementStockLevelByRetailer() {
    }

    /*@Test
    void shouldGetAllProducts() {
        //Given
        List<Product> products = new ArrayList<>();
        products.add(product);
        when(productRepository.findAll()).thenReturn(products);

        //when
        testObject.findAll();

        //then
        assertNotNull(products);

        verify(productRepository, times(1)).findAll();

    }*/

}