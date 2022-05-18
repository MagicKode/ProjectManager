package com.example.projectmanager.service.impl;

import com.example.projectmanager.mapper.ProductMapper;
import com.example.projectmanager.model.dto.ProductDto;
import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.model.entity.enums.RetailerName;
import com.example.projectmanager.factory.RandomProductFactory;
import com.example.projectmanager.repository.ProductRepository;
import com.example.projectmanager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;
    private final RandomProductFactory randomProductFactory;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public void insertRandomProducts(Integer quantity) {
        List<Product> products = IntStream
                .range(0, quantity)
                .mapToObj(i -> randomProductFactory.createRandomProduct())
                .collect(Collectors.toList());
        productRepository.saveAll(products);
        log.info("created products = {}", products);
    }

    @Override
    @Transactional
    public void incrementStockLevelByRetailerName(String name) {
        if (RetailerName.RET_A.name().equals(name)) {
            productRepository.incrementStockLevel(5, name);
        } else if (RetailerName.RET_B.name().equals(name)) {
            productRepository.incrementStockLevel(8, name);
        }
    }

    @Override
    public List<ProductDto> findByKeyWord(String keyword) {
        List<Product> findByKeyWord = productRepository.findProductsByKeyWord("%" + keyword + "%");
        log.info("Found product with title = {}", findByKeyWord);
        return productMapper.toListProductDto(findByKeyWord);
    }

    @Override
    public List<ProductDto> findAllProducts() {
        List<Product> Products = productRepository.findAll();
        log.info("Found all products");
        return productMapper.toListProductDto(Products);
    }

    @Override
    public ProductDto getById(Long id) {
        Product findProductById = productRepository.findById(id).orElse(null);
        log.info("Found product with id = {}", id);
        return productMapper.toProductDto(findProductById);
    }

    @Override
    @Transactional
    public ProductDto updateProduct(Product product) {
        Product productFromDb = productRepository.getById(product.getId());
        productFromDb.setTitle(product.getTitle());
        productFromDb.setDescription(product.getDescription());
        productFromDb.setStockLevel(product.getStockLevel());
        return productMapper.toProductDto(productRepository.save(productFromDb));
    }

    @Override
    @Transactional
    public void deleteProductById(Long id) {
        Product product = productRepository.getById(id);
        productRepository.delete(product);
        log.info("Deleted product with id = {}", id);
    }

    @Override
    @Transactional
    public Product create(Product product) {
        log.info("Product was created = {}", product);
        return productRepository.save(product);
    }
}
