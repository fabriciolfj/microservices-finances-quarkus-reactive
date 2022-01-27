package com.github.fabriciolfj.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExtractGetResponse {

    private String code;
    private LocalDateTime dataMov;
    private BigDecimal entrance;
    private BigDecimal exit;
    private BigDecimal balance;
}
