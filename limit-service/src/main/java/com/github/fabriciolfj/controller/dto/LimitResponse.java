package com.github.fabriciolfj.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LimitResponse {

    private String account;
    @JsonProperty("withdrawal_amount")
    private Integer withdrawalAmount;
    private BigDecimal rate;
    private LocalDateTime dataMov;
}
