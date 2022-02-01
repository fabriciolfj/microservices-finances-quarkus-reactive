package com.github.fabriciolfj.business.select;

import com.github.fabriciolfj.entity.LimitEntity;

import java.math.BigDecimal;

public abstract class SelectLimit {
    protected BigDecimal value;

    protected SelectLimit() {
        addValue();
    }

    public LimitEntity execute(final BigDecimal balance) {
        if (balance.compareTo(value) > 0) {
            return createLimity();
        }

        return next(balance);
    }

    protected abstract BigDecimal addValue();
    protected abstract LimitEntity next(final BigDecimal balance);
    protected abstract LimitEntity createLimity();
}

