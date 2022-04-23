package com.example.projectmanager.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.*;
import javax.security.auth.login.Configuration;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) && title.equals(product.title) && description.equals(product.description) && stockLevel.equals(product.stockLevel) && retailers.equals(product.retailers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, stockLevel, retailers);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", stockLevel='" + stockLevel + '\'' +
                ", retailers=" + retailers +
                '}';
    }
}
