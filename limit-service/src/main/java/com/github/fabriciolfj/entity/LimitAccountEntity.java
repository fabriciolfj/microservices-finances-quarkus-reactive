package com.github.fabriciolfj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LimitAccountEntity {

    private String account;
    private Integer withdrawalAmount;
    private BigDecimal rate;
    private LocalDateTime dataMov;
}
