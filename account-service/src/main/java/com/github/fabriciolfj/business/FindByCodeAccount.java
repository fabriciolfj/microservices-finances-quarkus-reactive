package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.AccountEntity;
import io.smallrye.mutiny.Uni;

public interface FindByCodeAccount {

    Uni<AccountEntity> findByCode(final String code);
}
