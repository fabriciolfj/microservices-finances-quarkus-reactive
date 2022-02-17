package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.entity.LimitAccountEntity;

public interface SetLimitCache {

    void addLimitToCache(final LimitAccountEntity limit);
}
