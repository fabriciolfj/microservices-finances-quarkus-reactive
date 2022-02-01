package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.LimitEntity;

import java.math.BigDecimal;

public class BasicLimit extends SelectLimit {

    @Override
    protected BigDecimal addValue() {
        return this.value = BigDecimal.valueOf(1000);
    }

    @Override
    protected LimitEntity next(final BigDecimal balance) {
        return new DefaultLimit()
                .execute(balance);
    }

    @Override
    protected LimitEntity createLimity() {
        return LimitEntity.builder()
                .rate(BigDecimal.valueOf(3.4))
                .withdrawalAmount(10).build();
    }
}
