package com.example.projectmanager.repository;

import com.example.projectmanager.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
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
    List<Product> findByKeyWord(@Param("keyword") String keyword);

    /*@Query(value = "" +
            "SELECT * FROM product p " +
            "inner join retailer_product rp " +
            "on p.product_id = rp.id_product " +
            "inner join retailer r " +
            "on r.retailer_id = rp.id_retailer " +
            "WHERE stock_level = :stockLevel " +
            "and r.name = :retailerName " +
            "and created_at between created_at = :startDate and updated_at = :endDate",
            nativeQuery = true)*/
//    List<Product> findParamsOfProductFoundByStockLevelRetailerStartDateEndDate(
//            @Param("stockLevel") Long stockLevel,
//            @Param("retailer") String retailer,
//            @Param("startDate") LocalDate createDate,
//            @Param("endDate") LocalDate updateDate
//    );
//

//    List<Product> findByStockLevelGreaterThanEqual(Long stockLevel);
    List<Product> findByRetailersNameEquals(String retailer);

//    @Modifying
//    @Transactional
//    @Query(value = "select p from Product p where p.createdAt >= :from and p.createdAt <= :to ")
//    List<Product> findByStartDateBetween(@Param("from") LocalDate startDate, @Param("to") LocalDate endDate);


}
