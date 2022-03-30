package com.example.projectmanager.service;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    Product product;

    @BeforeEach
    void init(){
        product = new Product();
        product.setId(1L);
        product.setTitle("Auto");
        product.setDescription("fast");
        product.setPrice(123.123);
    }

    @Test
    void shouldSaveProduct() {
        //given
        when(productRepository.save(product)).thenReturn(null);

        //when
        // result = productService.saveProduct(this.product);

        //then


    }

    @Test
    void shouldUpdateProduct() {
    }

    @Test
    void shouldGetProductById() {
    }

    @Test
    void shouldGetAllProducts() {
    }

    @Test
    void shouldDeleteProductById() {
    }

    @Test
    void shouldDeleteAllProducts() {
    }
}