package com.example.projectmanager.repository;

import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.model.entity.enums.RetailerName;
import org.springframework.data.jpa.repository.EntityGraph;
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
    @Query(value ="UPDATE Product p " +
            "SET p.stockLevel = p.stockLevel + :amount " +
            "WHERE (SELECT r FROM Retailer r WHERE r.name = :name) " +
            "member p.retailers"
    )
    void incrementStockLevel(Long amount, RetailerName name);

    @Query(value = "SELECT * FROM product WHERE title ILIKE :keyword OR description ILIKE :keyword", nativeQuery = true)
    List<Product> findByKeyWord(@Param("keyword") String keyword);

    @EntityGraph(attributePaths = {"retailers"})
    List<Product> findByStockLevelGreaterThanEqualAndRetailers_NameAndCreatedAtBetween(
            @Param("stockLevel") Long minStockLevel,
            @Param("retailerName") RetailerName retailerName,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
}
