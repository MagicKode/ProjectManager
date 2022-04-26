package com.example.projectmanager.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "retailer")
@AllArgsConstructor
public class Retailer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "retailer_id", unique = true)
    private Long retailer_id;
    @Column(name = "retailer_name")
    private String retailer_name;

    @ManyToMany(mappedBy = "retailers")
    private Set<Product> products = new HashSet<>();

    public Retailer() {}

    public Long getRetailer_id() {
        return retailer_id;
    }

    public void setRetailer_id(Long retailer_id) {
        this.retailer_id = retailer_id;
    }

    public String getRetailer_name() {
        return retailer_name;
    }

    public void setRetailer_name(String retailer_name) {
        this.retailer_name = retailer_name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Retailer retailer = (Retailer) o;
        return retailer_id.equals(retailer.retailer_id) && retailer_name.equals(retailer.retailer_name) && products.equals(retailer.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(retailer_id, retailer_name, products);
    }

    @Override
    public String toString() {
        return "Retailer{" +
                "retailer_id=" + retailer_id +
                ", retailer_name='" + retailer_name + '\'' +
                ", products=" + products +
                '}';
    }
}
