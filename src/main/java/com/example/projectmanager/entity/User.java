package com.example.projectmanager.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private Long id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_login")
    private String login;
    @Column(name = "user_password", length = 500)
    private String password;

    /*@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private Product product;*/

    public User() {
    }

    public User(String name, String login, String password/*, List<Product> products*/) {
        this.name = name;
        this.login = login;
        this.password = password;
        //this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Product> getProducts() {
//        return products;
//    }

//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

}
