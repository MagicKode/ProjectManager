package com.example.projectmanager.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

//@NamedNativeQuery(
//        name = "Product.findParamsOfProductFoundByStockLevelRetailerStartDateEndDate",
//        query = "SELECT * FROM product " +
//                "INNER JOIN retailer_product rp " +
//                "on product.product_id = rp.id_product " +
//                "inner join retailer r " +
//                "on r.retailer_id = rp.id_retailer " +
//                "WHERE stock_level = :stockLevel " +
//                "AND name = :retailerName " +
//                "AND to_date(created_at, 'YYYY-MM-DD') between to_date ('startDate', 'YYYY-MM-DD') AND to_date ('endDate', 'YYYY-MM-DD')"
//)
@Entity
@Table(name = "product")
@NoArgsConstructor
@Getter
@Setter
public class Product extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "stock_level")
    private Long stockLevel;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private Set<Retailer> retailers = new HashSet<>();
}
