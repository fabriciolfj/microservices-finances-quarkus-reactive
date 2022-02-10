package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.FindExtractLimitAccount;
import com.github.fabriciolfj.entity.LimitAccountEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class FindLimitsAccount {

    private final FindExtractLimitAccount find;

    public List<LimitAccountEntity> findPerAccount(final String account) {
        log.info("find limits account {}", account);
        return find.findAllPerAccount(account);
    }
}
