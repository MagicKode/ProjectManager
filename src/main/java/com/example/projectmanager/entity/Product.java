package com.example.projectmanager.entity;

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
    private List<User>users;


    public Product() {
    }

    public Product(String title, String description, List<User> users, String stockLevel) {
        this.title = title;
        this.description = description;
        this.users = users;
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
        Random r = new Random();
        char letter = (char)(r.nextInt(26) + 'a');
        title = "Product_"+ letter;
        this.title = title;
    }

    public String getDescription() {
       return description;
    }

    public void setDescription(String description) {
        //letters creation
        Random r = new Random();
        char letter = (char) (r.nextInt(26) + 'a');

        //numbers creation
        int n = 100;
        Random r1 = new Random();
        int num = r1.nextInt(n);

        description = "Description: "+letter+""+num;
        this.description = description;
    }

    public String getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(String stockLevel) {
        Random r = new Random();
        int num = r.nextInt();
        stockLevel = "StockLevel: " + num;
        this.stockLevel = stockLevel;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
