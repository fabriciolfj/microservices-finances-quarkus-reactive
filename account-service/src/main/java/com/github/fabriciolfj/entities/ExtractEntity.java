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

    public ExtractEntity calculateCredit(final BigDecimal value) {
        this.balance = this.balance.add(value);
        this.entrance = value;
        this.exit = BigDecimal.ZERO;
        this.dateMov = LocalDateTime.now();
        return this;
    }

    public ExtractEntity calculateDebit(final BigDecimal value) {
        this.balance = this.balance.subtract(value);
        this.exit = value;
        this.entrance = BigDecimal.ZERO;
        this.dateMov = LocalDateTime.now();
        return this;
    }
}
