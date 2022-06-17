package com.example.projectmanager.repository;

import com.example.projectmanager.model.entity.Retailer;
import com.example.projectmanager.model.entity.enums.RetailerName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailerRepository extends JpaRepository<Retailer, Long> {
    Retailer findByName(RetailerName name);
}
