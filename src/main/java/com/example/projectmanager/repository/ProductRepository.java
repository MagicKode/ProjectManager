package com.example.projectmanager.repository;

import com.example.projectmanager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query(value = "" +
            "update product " +
            "set stock_level = stock_level + :amount " +
            "from retailer_product " +
            "inner join retailer " +
            "    on retailer.retailer_id = retailer_product.id_retailer " +
            "where retailer.name = :name",
            nativeQuery = true)
    void incrementStockLevel(Integer amount, String name);
}