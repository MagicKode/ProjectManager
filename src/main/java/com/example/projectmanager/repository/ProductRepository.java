package com.example.projectmanager.repository;

import com.example.projectmanager.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Query(value = " UPDATE product " +
            "SET stock_level = stock_level + :amount " +
            "from retailer_product " +
            "inner join retailer " +
            "ON retailer.retailer_id = retailer_product.id_retailer " +
            "WHERE product.product_id = retailer_product.id_product AND retailer.name = :name",
            nativeQuery = true)
//            value = "UPDATE Product p SET p.stockLevel = p.stockLevel + :amount WHERE Retailer.name = :name")//TODO JPQL
    void incrementStockLevel(Integer amount, String name);

    @Query(value = "SELECT * FROM product WHERE title ILIKE :keyword OR description ILIKE :keyword", nativeQuery = true)
    List<Product> findByKeyWord(@Param("keyword") String keyword);

//    @Query(value = "SELECT p " +
//            "FROM Product p " +
//            "JOIN FETCH p.retailers r " +
//            "WHERE p.stockLevel >= :stockLevel " +
//            "AND r.name = :retailerName " +
//            "AND p.createdAt between :startDate " +
//            "AND :endDate ")


    //    @ElementCollection(fetch = FetchType.EAGER, targetClass = Retailer.class)
    List<Product> findByStockLevelGreaterThanEqualAndRetailers_NameAndCreatedAtBetween(
            @Param("stockLevel") Long stockLevel,
            @Param("retailerName") String retailerName,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
}
