package com.github.fabriciolfj.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {

    private String code;
    private BigDecimal balance;
    private LocalDateTime dateMov;
    private List<ExtractEntity> extracts;
}
