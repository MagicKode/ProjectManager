package com.example.projectmanager.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "stockLevel")
    private Long stockLevel;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_retailer",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "retailer_id")}
    )

    private Set<Retailer> retailers = new HashSet<>();

    public Product() {}

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

    public Long getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Long stockLevel) {
        this.stockLevel = stockLevel;
    }

    public Set<Retailer> getRetailers() {
        return retailers;
    }

    public void setRetailers(Set<Retailer> retailers) {
        this.retailers = retailers;
    }

    public void retailer(Retailer retailer) {
        retailers.add(retailer);
    }
}
