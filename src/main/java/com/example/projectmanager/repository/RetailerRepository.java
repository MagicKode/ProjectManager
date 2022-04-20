package com.example.projectmanager.repository;

import com.example.projectmanager.entity.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailerRepository extends JpaRepository<Retailer, Long> {

    Retailer findRetailerByName(String name);

}
