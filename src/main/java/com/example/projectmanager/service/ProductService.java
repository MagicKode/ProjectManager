package com.example.projectmanager.service;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.entity.User;
import com.example.projectmanager.repository.ProductRepository;
import com.example.projectmanager.service.impl.ProductInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService implements ProductInterface {

    private final ProductRepository productRepository;

    @Override
    public Product generateProduct() { //автоматический генератор продукта, работает постоянно автономно
        List<Product> products = new ArrayList<>();
        try {
            sleep(500_000);
            products.add(new Product());
            products.add(new Product());
            products.add(new Product());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return productRepository.saveProduct(products);
    }

    @Override
    public Product addProductByUser(Product product) { //сохраняет продукт User
        User user = new User();
        if (user.getName().equals("User")) {
            List<Product> products = new ArrayList<>(20);
            products.add(product);
            return productRepository.saveProduct(products);
        }
        return null;
    }

    @Override
    public Product saveProductByRetailers(Product product) { //создание продукта Продавцами
        User user = new User();
        if (user.getName().equals("Ret_A") || user.getLogin().equals("Rest_B")) {
            List<Product> products = new ArrayList<>();
            products.add(product);
            return productRepository.saveProduct(products);
        } else {
            return null;
        }
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
