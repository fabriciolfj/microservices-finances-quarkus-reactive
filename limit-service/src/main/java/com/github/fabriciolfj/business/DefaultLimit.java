package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.LimitEntity;

import java.math.BigDecimal;

public class DefaultLimit extends SelectLimit {

    @Override
    protected BigDecimal addValue() {
        return this.value = BigDecimal.ZERO;
    }

    @Override
    protected LimitEntity next(final BigDecimal balance) {
        throw new RuntimeException("Limit not found, to balance: " + balance);
    }

    @Override
    protected LimitEntity createLimity() {
        return LimitEntity.builder()
                .rate(BigDecimal.valueOf(6.7))
                .withdrawalAmount(5).build();
    }
}
