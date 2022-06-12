package com.example.projectmanager.mapper;

import com.example.projectmanager.model.dto.RetailerDto;
import com.example.projectmanager.model.entity.Retailer;
import org.mapstruct.Mapper;

@Mapper
public interface RetailerMapper {
    RetailerDto toRetailerDto(Retailer retailer);
}
