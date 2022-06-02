package com.example.projectmanager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class ReportMessageDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private Long minStockLevel;
    private RetailerDto retailer;
}
