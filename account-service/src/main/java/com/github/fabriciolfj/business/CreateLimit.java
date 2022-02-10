package com.github.fabriciolfj.business;

import java.math.BigDecimal;

public interface CreateLimit {

    void create(final String account, final BigDecimal balance);
}
