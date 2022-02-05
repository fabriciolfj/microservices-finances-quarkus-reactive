package com.github.fabriciolfj.providers.database;

import com.github.fabriciolfj.business.CreateAccount;
import com.github.fabriciolfj.business.FindByCodeAccount;
import com.github.fabriciolfj.business.ListAccounts;
import com.github.fabriciolfj.entities.AccountEntity;
import com.github.fabriciolfj.providers.database.converter.AccountDataConverter;
import com.github.fabriciolfj.providers.database.model.AccountData;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AccountRepositoryProvider implements CreateAccount, ListAccounts, FindByCodeAccount {

    @Override
    public Uni<String> execute(final AccountEntity accountEntity) {
        return Uni.createFrom().item(accountEntity)
                .onItem().transform(entity -> AccountDataConverter.toData(accountEntity))
                .flatMap(data -> Panache.withTransaction(data::persist))
                .onItem()
                .transform(value -> ((AccountData) value).getCode());
    }

    @Override
    public Multi<AccountEntity> findAll() {
        return listAll().toMulti().concatMap(v -> Multi.createFrom().items(v.stream()))
                .onItem().transform(v -> AccountDataConverter.toEntity(v));
    }

    @Override
    public Uni<AccountEntity> findByCode(final String code) {
        return find(code)
                .onItem().ifNull().failWith(new RuntimeException("Account not found : " + code))
                .onItem().transform(value -> AccountDataConverter.toEntity(value));

    }

    private Uni<List<AccountData>> listAll() {
        return AccountData
                .list("Select e From AccountData e join fetch e.extractData order by e.dataMov");
    }

    private Uni<AccountData> find(String code) {
        return AccountData.find("Select e From AccountData e join fetch e.extractData where e.code =?1", code)
                .firstResult();
    }
}
