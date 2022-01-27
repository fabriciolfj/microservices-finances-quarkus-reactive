package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.AccountEntity;
import io.smallrye.mutiny.Multi;

public interface ListAccounts {

    Multi<AccountEntity> findAll();
}
