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

        log.info("Saving new Product. Title: {}; Author login: {}", product.getTitle(), product.getRetailer());
        productRepository.save(product); // обновляем репозиторий,(добавляем продукт уже С ФОТО)
    }

    @Override
    public Product updateProduct(String title, int price, String description, Long stockLevel) {
        return null;
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProductById(long id) {
        //если нет такого id, то возвращаем НОЛЬ или сообщенеи, что ТАКОГО ПРОДУКТА НЕТ!
        productRepository.deleteById(id);
    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();

    }
}
