package com.example.projectmanager.repository;

import com.example.projectmanager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getProductById(Long id);

    Product saveProduct(List<Product> products);
}
