package com.github.fabriciolfj.business;

import com.github.fabriciolfj.business.select.PremiumLimit;
import com.github.fabriciolfj.entity.LimitAccountEntity;
import com.github.fabriciolfj.entity.LimitEntity;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@ApplicationScoped
public class FindLimit {

    public LimitAccountEntity execute(final String account, final BigDecimal balance) {
        final LimitEntity limit = new PremiumLimit().execute(balance);
        return LimitAccountEntity
                .builder()
                .rate(limit.getRate())
                .withdrawalAmount(limit.getWithdrawalAmount())
                .account(account)
                .build();
    }


}
