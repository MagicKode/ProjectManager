package com.example.projectmanager.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "retailer")
@NoArgsConstructor
@Getter
@Setter
public class Retailer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "retailer_id", unique = true)
    private Long id;
    @Column(name = "name")
    private String name;


    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinTable(
            name = "retailer_product",
            joinColumns = {@JoinColumn(name = "id_retailer")},
            inverseJoinColumns = {@JoinColumn(name = "id_product")}
    )
    private Set<Product> products = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Retailer retailer = (Retailer) o;
        return id.equals(retailer.id) && name.equals(retailer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
