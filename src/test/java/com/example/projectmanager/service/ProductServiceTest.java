package com.example.projectmanager.service;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.repository.ProductRepository;
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
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService testObject;

    Product product;

    @BeforeEach
    void init(){
        product = new Product();
        product.setId(1L);
        product.setTitle("Auto");
        product.setDescription("fast");
    }

    @Test
    void shouldGenerateProduct(){

    }

    @Test
    void addProductByUser(Product product){

    }

    @Test
    void saveProductByRetailers(Product product) {

    }

    @Test
    void shouldGetProductById() {
        //given
        Product product = new Product();
        Long id = 1L;
        product.setId(id);
        when(productRepository.getProductById(id)).thenReturn(product);

        //when
        testObject.getProductById(product.getId());

        //then
        assertNotNull(product);
        assertEquals(1L, product.getId());

        verify(productRepository, times(1)).getProductById(product.getId());
    }

    @Test
    void shouldGetAllProducts() {
        //Given
        List<Product> products = new ArrayList<>();
        products.add(product);
        when(productRepository.findAll()).thenReturn(products);

        //when
        testObject.getAllProducts();

        //then
        assertNotNull(products);

        verify(productRepository, times(1)).findAll();

    }

    @Test
    void shouldDeleteProductById() {
        //given
        Product product = new Product();
        Long id = 1L;
        product.setId(id);

        //when
        testObject.deleteProductById(product.getId());

        //then
        verify(productRepository, times(1)).deleteById(product.getId());

    }

    @Test
    void shouldDeleteAllProducts() {
        //given
        List<Product> products = new ArrayList<>();
        products.add(product);

        //when
        testObject.deleteAllProducts();

        //then
        assertEquals(1, products.size());

        verify(productRepository, times(1)).deleteAll();
    }
}