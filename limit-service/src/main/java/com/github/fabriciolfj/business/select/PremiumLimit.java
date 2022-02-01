package com.github.fabriciolfj.business.select;

import com.github.fabriciolfj.entity.LimitEntity;

import java.math.BigDecimal;

public class PremiumLimit extends SelectLimit{

    @Override
    protected BigDecimal addValue() {
        return this.value = BigDecimal.valueOf(2000);
    }

    @Override
    protected LimitEntity next(final BigDecimal balance) {
        return new BasicLimit()
                .execute(balance);
    }

    @Override
    protected LimitEntity createLimity() {
        return LimitEntity.builder()
                .rate(BigDecimal.valueOf(0.9))
                .withdrawalAmount(20).build();
    }
}
