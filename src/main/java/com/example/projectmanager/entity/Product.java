package com.example.projectmanager.entity;

import com.example.projectmanager.entity.role.Retailer;

import javax.persistence.*;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "product")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_title")
    private String title;
    @Column(name = "product_description")
    private String description;
    @Column(name = "product_stockLevel")
    private String stockLevel;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private List<Retailer>retailers;


    public Product() {
    }

    public Product(String title, String description, List<Retailer> retailers, String stockLevel) {
        this.title = title;
        this.description = description;
        this.retailers = retailers;
        this.stockLevel = stockLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
       return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(String stockLevel) {
        this.stockLevel = stockLevel;
    }

    public List<Retailer> getRetailers() {
        return retailers;
    }

    public void setRetailers(List<Retailer> retailers) {
        this.retailers = retailers;
    }

}
