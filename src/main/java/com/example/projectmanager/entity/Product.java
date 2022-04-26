package com.example.projectmanager.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long product_id;
    @Column(name = "product_title")
    private String product_title;
    @Column(name = "product_description")
    private String product_description;
    @Column(name = "product_stockLevel")
    private Long product_stockLevel;

    /*@ManyToMany(mappedBy = "products")
    @JoinTable(name = "")*/
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_retailer",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "retailer_id")}
    )
    private Set<Retailer> enrollRetailers = new HashSet<>();

    public Product() {}

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public Long getProduct_stockLevel() {
        return product_stockLevel;
    }

    public void setProduct_stockLevel(Long product_stockLevel) {

        this.product_stockLevel = product_stockLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return product_id.equals(product.product_id) && product_title.equals(product.product_title) && product_description.equals(product.product_description) && product_stockLevel.equals(product.product_stockLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, product_title, product_description, product_stockLevel);
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_title='" + product_title + '\'' +
                ", product_description='" + product_description + '\'' +
                ", product_stockLevel=" + product_stockLevel +
                '}';
    }

    public void enrollRetailer(Retailer retailer) {
        enrollRetailers.add(retailer);
    }
}
