package com.example.projectmanager.entity;

import com.example.projectmanager.entity.ProductDetails.ProductDescription;
import com.example.projectmanager.entity.ProductDetails.ProductTitle;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@AllArgsConstructor
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
    private List<User>users;


    public Product() {
    }

    public Product(String title, String description, List<User> users) {
        this.title = title;
        this.description = description;
        this.users = users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
