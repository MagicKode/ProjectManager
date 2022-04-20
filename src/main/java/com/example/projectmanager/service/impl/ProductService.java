package com.example.projectmanager.service.impl;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.factory.impl.RandomProductFactoryImpl;
import com.example.projectmanager.repository.ProductRepository;
import com.example.projectmanager.service.ProductInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class ProductService implements ProductInterface {

    private final ProductRepository productRepository;
    private RandomProductFactoryImpl productServiceFactory;


    @Override
    public List<Product> addProductByUser(Product product) {
        List<Product> products = new ArrayList<>(20);
        productServiceFactory.generateRandomProduct(product);
        products.add(product);
        log.info("User added product = {}", product);
        productRepository.save(product);
        return products;
    }

    @Override
    public Product saveProductByRetailers(Product product) {

        log.info("Saved product = {}", product);
        return productRepository.save(product);
    }



    @Override
    public Product getProductById(long id) {
        log.info("Got product with id = {}", id);
        return productRepository.getById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        log.info("Got all products");
        return productRepository.findAll();
    }

    @Override
    public void deleteProductById(long id) {
        log.info("Deleted product with id = {}", id);
        productRepository.deleteById(id);
    }

    @Override
    public void deleteAllProducts() {
        log.info("Deleted all products");
        productRepository.deleteAll();
    }


}
