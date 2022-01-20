package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.ListAccounts;
import com.github.fabriciolfj.entities.AccountEntity;
import io.smallrye.mutiny.Multi;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class GetAllAccountsUseCase {

    private final ListAccounts listAccounts;

    public Multi<AccountEntity> execute() {
        return listAccounts.findAll();
    }
}
