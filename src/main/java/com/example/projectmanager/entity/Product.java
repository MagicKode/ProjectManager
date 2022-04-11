package com.example.projectmanager.entity;

import com.example.projectmanager.entity.ProductDetails.ProductDescription;
import com.example.projectmanager.entity.ProductDetails.ProductTitle;

import javax.persistence.*;


@Table(name = "product")
public class Product {

    private ProductTitle productTitle;
    private ProductDescription productDescription;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_title")
    private String title = productTitle.createTitle();
    @Column(name = "product_description")
    private String description = productDescription.createDescription();

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;


    public Product() {
    }

    public Product(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
