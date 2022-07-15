package com.example.projectmanager.model.dto;

import com.example.projectmanager.model.entity.enums.TypeReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class ReportMessageDto {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long minStockLevel;
    private RetailerDto retailer;
    private TypeReport type;
}
