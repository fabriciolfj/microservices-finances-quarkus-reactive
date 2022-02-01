package com.github.fabriciolfj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LimitEntity {

    private String account;
    private Integer withdrawalAmount;
    private BigDecimal rate;
}
