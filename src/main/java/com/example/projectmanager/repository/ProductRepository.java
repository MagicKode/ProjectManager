package com.example.projectmanager.repository;

import com.example.projectmanager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
