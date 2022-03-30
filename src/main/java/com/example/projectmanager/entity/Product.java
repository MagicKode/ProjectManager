package com.example.projectmanager.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "StockLevel")
    private Long StockLevel; //quantity of products (how many are available)
    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private Retailer retailer;


    public Product() {
    }

    public Product(String title, Long stockLevel, double price, String description, Retailer retailer) {
        this.title = title;
        StockLevel = stockLevel;
        this.price = price;
        this.description = description;
        this.retailer = retailer;
    }

    public Product(String title, Long stockLevel, double price, String description) {
        this.title = title;
        StockLevel = stockLevel;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && id.equals(product.id) && title.equals(product.title) && StockLevel.equals(product.StockLevel) && description.equals(product.description) && retailer.equals(product.retailer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, StockLevel, price, description, retailer);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", StockLevel=" + StockLevel +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", retailer=" + retailer +
                '}';
    }
}
