package com.example.projectmanager.model.dto;

import com.example.projectmanager.model.entity.enums.RetailerName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RetailerDto {
    private Long id;
    private RetailerName name;
}
