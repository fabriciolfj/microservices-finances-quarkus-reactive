package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.LimitAccountEntity;

import java.util.List;

public interface FindExtractLimitAccount {

    List<LimitAccountEntity> findAllPerAccount(final String account);
}
