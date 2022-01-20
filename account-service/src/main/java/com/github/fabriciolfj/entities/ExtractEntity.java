package com.github.fabriciolfj.entities;

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
public class ExtractEntity {

    private String code;
    private BigDecimal entrance;
    private BigDecimal exit;
    private BigDecimal balance;
    private LocalDateTime dateMov;
}
