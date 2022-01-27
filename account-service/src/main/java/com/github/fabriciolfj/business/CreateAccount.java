package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.AccountEntity;
import io.smallrye.mutiny.Uni;

public interface CreateAccount {

    Uni<String> execute(final AccountEntity accountEntity);
}
