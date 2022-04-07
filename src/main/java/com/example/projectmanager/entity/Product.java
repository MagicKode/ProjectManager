package com.example.projectmanager.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "product")
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "StockLevel")
    private Long StockLevel; //quantity of products (how many are available)
    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;


    public Product() {
    }

    public Product(String title, Long stockLevel, String description, User user) {
        this.title = title;
        StockLevel = stockLevel;
        this.description = description;
        this.user = user;
    }

    public Product(String title, Long stockLevel, String description) {
        this.title = title;
        StockLevel = stockLevel;
        this.description = description;
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

    public Long getStockLevel() {
        return StockLevel;
    }

    public void setStockLevel(Long stockLevel) {
        StockLevel = stockLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) && title.equals(product.title) && StockLevel.equals(product.StockLevel) && description.equals(product.description) && user.equals(product.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, StockLevel, description, user);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", StockLevel=" + StockLevel +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
