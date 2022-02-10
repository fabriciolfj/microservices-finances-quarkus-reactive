package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.CreateAccount;
import com.github.fabriciolfj.business.CreateLimit;
import com.github.fabriciolfj.entities.AccountEntity;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class CreateAccountUseCase {

    private final CreateAccount createAccount;
    private final CreateLimit createLimit;

    public Uni<String> execute(final AccountEntity accountEntity) {
        log.info("Saving account: {}", accountEntity);
        return createAccount.execute(accountEntity)
                .onItem()
                .invoke(c -> createLimit.create(c.getCode(), c.getBalance()))
                .onItem()
                .transform(c -> c.getCode());
    }
}
