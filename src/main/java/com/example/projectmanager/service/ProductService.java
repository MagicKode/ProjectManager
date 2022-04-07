package com.example.projectmanager.service;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.repository.ProductRepository;
import com.example.projectmanager.service.impl.ProductInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService implements ProductInterface {

    private final ProductRepository productRepository;


    @Override
    public void saveProduct(Product product) {



        log.info("Saving new Product. Title: {}; Author login: {}", product.getTitle(), product.getUser());
        productRepository.save(product); // обновляем репозиторий,(добавляем продукт уже С ФОТО)
    }

    @Override
    public Product getProductById(long id) {
        log.info("Got product with id = {}", id);
        return productRepository.getProductById(id);
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
