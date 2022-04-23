package com.example.projectmanager.service.impl;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.factory.impl.RandomProductFactoryImpl;
import com.example.projectmanager.repository.ProductRepository;
import com.example.projectmanager.service.ProductInterface;
import com.example.projectmanager.service.schedule.GeneratedProductJob;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class ProductService implements ProductInterface {

    private final ProductRepository productRepository;
    private RandomProductFactoryImpl productServiceFactory;
    private EntityManager entityManager;
    private final GeneratedProductJob productJob;

    @Transactional
    public Product createProduct(){
        Product product = new Product();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        productServiceFactory.createRandomProduct();
        entityManager.persist(product);
        log.info("Created product = {}", product);
        entityManager.flush();
        entityTransaction.commit();
        return productRepository.save(product);
    }


    @Override
    @Transactional
    public List<Product> createSomeRandomProducts(Product product) {
        List<Product> products = new ArrayList<>(20);
        EntityTransaction transaction = entityManager.getTransaction(); //убрать
        try {
            transaction.begin();
            products.add(productServiceFactory.createRandomProduct());
            entityManager.persist(products);
            log.info("User added products = {}", products);
            entityManager.flush();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException(e); //добавить message
        }
        productRepository.saveAll(products);
        return products;
    }

    @Override
    @Transactional
    public void createRandomProductsEveryFiveMinutes() {
        Product product = ;

        List<Product> products= Arrays.asList(
                productRepository.save(productJob.productScheduler()),
                productRepository.save(product),
                productRepository.save(product)
        );
        log.info("Created product = {}", products);
    }
}
