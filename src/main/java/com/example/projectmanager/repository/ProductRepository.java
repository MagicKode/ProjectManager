package com.example.projectmanager.repository;

import com.example.projectmanager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "" +
            "UPDATE product " +
            "SET stock_level = stock_level + :amount " +
            "FROM product " +
            "JOIN retailer_product " +
            "ON product.product_id = retailer_product.id_product " +
            "JOIN retailer " +
            "ON retailer_product.id_retailer = retailer.retailer_id " +
            "WHERE retailer.name = :name",
            nativeQuery = true)
    void incrementStockLevel(Integer amount);

}