package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.LimitAccountEntity;
import io.smallrye.mutiny.Uni;

public interface UpdateCache {

    Uni<LimitAccountEntity> update(final LimitAccountEntity limitAccountEntity);
}
