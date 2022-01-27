package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.FindByCodeAccount;
import com.github.fabriciolfj.entities.AccountEntity;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class GetAccountByCodeUseCase {

    private final FindByCodeAccount findByCodeAccount;

    public Uni<AccountEntity> execute(final String code) {
        return findByCodeAccount.findByCode(code)
                .log();
    }
}
