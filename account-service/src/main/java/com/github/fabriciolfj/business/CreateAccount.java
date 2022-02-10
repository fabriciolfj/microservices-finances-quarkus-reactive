package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.AccountEntity;
import io.smallrye.mutiny.Uni;

public interface CreateAccount {

    Uni<AccountEntity> execute(final AccountEntity accountEntity);
}
