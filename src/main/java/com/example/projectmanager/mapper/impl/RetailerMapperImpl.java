package com.example.projectmanager.mapper.impl;

import com.example.projectmanager.mapper.RetailerMapper;
import com.example.projectmanager.model.dto.RetailerDto;
import com.example.projectmanager.model.entity.Retailer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RetailerMapperImpl implements RetailerMapper {
    @Override
    public RetailerDto toRetailerDto(Retailer retailer) {
        RetailerDto retailerDto = new RetailerDto();
        retailerDto.setId(retailer.getId());
        retailerDto.setName(retailer.getName());
        return retailerDto;
    }
}
