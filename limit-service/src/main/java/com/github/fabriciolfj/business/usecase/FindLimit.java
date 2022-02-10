package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.usecase.select.PremiumLimit;
import com.github.fabriciolfj.entity.LimitAccountEntity;
import com.github.fabriciolfj.entity.LimitEntity;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApplicationScoped
@RequiredArgsConstructor
public class FindLimit {

    public LimitAccountEntity execute(final String account, final BigDecimal balance) {
        final LimitEntity limit = new PremiumLimit().execute(balance);
        return LimitAccountEntity
                .builder()
                .rate(limit.getRate())
                .withdrawalAmount(limit.getWithdrawalAmount())
                .account(account)
                .dataMov(LocalDateTime.now())
                .build();
    }


}
