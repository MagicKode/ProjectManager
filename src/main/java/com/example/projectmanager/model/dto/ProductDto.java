package com.example.projectmanager.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long id;
    private String title;
    private String description;
    private Long stockLevel;
    private Set<RetailerDto> retailers = new HashSet<>();
}
