package com.example.projectmanager.repository;

import com.example.projectmanager.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query(value = "" +
            "UPDATE product " +
            "SET stock_level = stock_level + :amount " +
            "from retailer_product "+
            "join retailer " +
            "ON retailer.retailer_id = retailer_product.id_retailer " +
            "WHERE retailer.name = :name",
            nativeQuery = true)
    void incrementStockLevel(Integer amount, String name);

    @Query(value = "" +
            "select * " +
            "from product " +
            "where title " +
            "ilike :keyword  " +
            "or description " +
            "ilike :keyword",
            nativeQuery = true)
    List<Product> findAll(@Param("keyword") String keyword);
}
