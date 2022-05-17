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
            "from retailer_product " +
            "inner join retailer " +
            "ON retailer.retailer_id = retailer_product.id_retailer " +
            "WHERE product.product_id = retailer_product.id_product AND retailer.name = :name",
            nativeQuery = true)
    void incrementStockLevel(Integer amount, String name);

    @Query(value = "" +
            "SELECT * " +
            "FROM product " +
            "WHERE title " +
            "ILIKE :keyword  " +
            "OR description " +
            "ILIKE :keyword",
            nativeQuery = true)
    List<Product> findProductsByKeyWord(@Param("keyword") String keyword);
}
