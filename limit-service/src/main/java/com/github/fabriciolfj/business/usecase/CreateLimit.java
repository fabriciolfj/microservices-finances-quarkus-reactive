package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.LimitSave;
import com.github.fabriciolfj.entity.LimitAccountEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class CreateLimit {

    private final LimitSave limitSave;
    private final FindLimit findLimit;
    private final SetLimitCache setLimitCache;

    public LimitAccountEntity execute(final String account, final BigDecimal balance) {
        final var limit = findLimit.execute(account, balance);

        log.info("Save limit to account {}, limit {}", account, limit);
        limitSave.save(limit);
        setLimitCache.addLimitToCache(limit);
        return limit;
    }
}
