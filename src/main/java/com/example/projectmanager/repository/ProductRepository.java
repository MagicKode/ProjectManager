package com.example.projectmanager.repository;

import com.example.projectmanager.model.entity.Product;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying//?????TODO выяснить для чего эта анотация, и рассказать: нужна ли она и что делает
    @Query(value = "UPDATE product " +
            "SET stock_level = stock_level + :amount " +
            "from retailer_product " +
            "inner join retailer " +
            "ON retailer.retailer_id = retailer_product.id_retailer " +
            "WHERE product.product_id = retailer_product.id_product AND retailer.name = :name",
            nativeQuery = true
    )//TODO jpql
//    @Query("UPDATE Product p set p.stockLevel = p.stockLevel + :amount WHERE Retailer.name = :name")
    void incrementStockLevel(Integer amount, String name);

    @Query(value = "SELECT * FROM product WHERE title ILIKE :keyword OR description ILIKE :keyword", nativeQuery = true)
    List<Product> findByKeyWord(@Param("keyword") String keyword);

//    List<Product> findByStockLevelGreaterThanEqualAndRetailers_NameAndCreatedAtBetween( //TODO research name of method
//    List<Product> findByStockLevelGreaterThanEqualAndRetailers_NameAndCreatedAtWithinInterval( //TODO research name of method
//    List<Product> findByStockLevelGreaterThanEqualAndRetailers_NameAndCreatedAtAfterAndUpdatedAtBefore( //TODO research name of method
    List<Product> findByStockLevelGreaterThanEqualAndRetailers_NameAndCreatedAtAndUpdatedAt( //TODO research name of method


            @Param("stockLevel") Long stockLevel,
            @Param("retailerName") String retailerName,
            @Param("startDate") LocalDateTime createDate,
            @Param("endDate") LocalDateTime updateDate
    );
}
