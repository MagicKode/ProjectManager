package com.example.projectmanager.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long id;
    private String title;
    private String description;
    private Long stockLevel;
}
