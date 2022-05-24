package com.example.projectmanager.service.impl;

import com.example.projectmanager.exception.NotFoundException;
import com.example.projectmanager.factory.impl.RandomProductFactoryImpl;
import com.example.projectmanager.mapper.ProductMapper;
import com.example.projectmanager.model.dto.ProductDto;
import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.model.entity.enums.RetailerName;
import com.example.projectmanager.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    ProductRepository productRepository;
    @Mock
    RandomProductFactoryImpl randomProductFactory;
    @Mock
    ProductMapper productMapper;

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

    @Test
    void shouldFindByKeyWord() {
        //given
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setTitle("title");
        products.add(product);
        List<ProductDto> productsDto = new ArrayList<>();
        ProductDto productDto = new ProductDto();
        productDto.setTitle("title");
        productsDto.add(productDto);
        String keyword = "title";
        String modKeyword = "%" + keyword + "%";
        when(productRepository.findByKeyWord(modKeyword)).thenReturn(products);
        when(productMapper.toListProductDto(products)).thenReturn(productsDto);

        //when
        List<ProductDto> result = testSubject.findByKeyWord(keyword);

        //then
        assertEquals(1, result.size());
        assertEquals(productsDto, result);
        verify(productRepository, times(1)).findByKeyWord(modKeyword);
        verify(productMapper, times(1)).toListProductDto(products);
    }

    @Test
    void shouldFindAll() {
        //given
        Product product = new Product();
        List<Product> products = new ArrayList<>();
        products.add(product);
        List<ProductDto> productDtos = new ArrayList<>();
        ProductDto productDto = new ProductDto();
        productDtos.add(productDto);
        when(productRepository.findAll()).thenReturn(products);
        when(productMapper.toListProductDto(products)).thenReturn(productDtos);

        //when
        List<ProductDto> result = testSubject.findAll();

        //then
        assertEquals(productDtos, result);
        verify(productRepository, times(1)).findAll();
        verify(productMapper, times(1)).toListProductDto(products);

    }

    @Test
    void shouldFindById() {
        //given
        Product product = new Product();
        product.setId(1L);
        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(productMapper.toProductDto(product)).thenReturn(productDto);

        //when
        ProductDto result = testSubject.findById(product.getId());

        //then
        assertEquals(product.getId(), result.getId());
        verify(productRepository, times(1)).findById(product.getId());
        verify(productMapper, times(1)).toProductDto(product);
    }

    @Test
    void shouldThrowExceptionWhenNotFoundById() {
        //given
        Long id = 1L;
        String errorMessage = "No product found with such id = " + id;

        //when
        NotFoundException result = Assertions
                .assertThrows(NotFoundException.class, () -> testSubject.findById(id));
        //then
        Assertions.assertEquals(errorMessage, result.getMessage());
        verify(productRepository, times(1)).findById(id);
    }

    @Test
    void shouldUpdate() {
        //given
        Product productFromDB = new Product();
        productFromDB.setId(1L);
        productFromDB.setTitle("Title");

        Product product = new Product();
        ProductDto productDto = new ProductDto();
        productDto.setTitle(product.getTitle());
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(productFromDB));
        when(productRepository.save(productFromDB)).thenReturn(productFromDB);
        when(productMapper.toProductDto(productFromDB)).thenReturn(productDto);

        //when
        ProductDto result = testSubject.update(product);

        //then
        assertEquals(product.getTitle(), result.getTitle());
        verify(productRepository, times(1)).findById(product.getId());
        verify(productRepository, times(1)).save(productFromDB);
    }

    @Test
    void shouldThrowExceptionWhenNotUpdated() {
        //given
        Product product = new Product();
        Long id = 1L;
        product.setId(id);
        String errorMessage = "No product updated with such id = " + id;

        //when
        NotFoundException result = Assertions
                .assertThrows(NotFoundException.class, () -> testSubject.update(product));
        //then
        Assertions.assertEquals(errorMessage, result.getMessage());
        verify(productRepository, times(1)).findById(id);
    }

    @Test
    void shouldDeleteById() {
        //given
        Long id = 1L;
        Product product = new Product();
        product.setId(id);
        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        //when
        testSubject.deleteById(id);

        //then
        verify(productRepository, times(1)).findById(id);
        verify(productRepository, times(1)).delete(product);
    }

    @Test
    void shouldThrowExceptionWhenNotDelete() {
        //given
        Long id = 1L;
        String errorMessage = "No product deleted with such id = " + id;

        //when
        NotFoundException result = Assertions.assertThrows(
                NotFoundException.class, () -> testSubject.deleteById(id));

        //then
        Assertions.assertEquals(errorMessage, result.getMessage());
        verify(productRepository, times(1)).findById(id);
    }

    @Test
    void shouldCreate() {
        //given
        Product product = new Product();

        //when
        testSubject.create(product);

        //then
        verify(productRepository, times(1)).save(product);
    }
}
