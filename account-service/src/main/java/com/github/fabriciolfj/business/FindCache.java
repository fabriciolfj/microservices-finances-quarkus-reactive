package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.LimitAccountEntity;
import io.smallrye.mutiny.Uni;

public interface FindCache {

    Uni<LimitAccountEntity> getCache(final String account);
}
