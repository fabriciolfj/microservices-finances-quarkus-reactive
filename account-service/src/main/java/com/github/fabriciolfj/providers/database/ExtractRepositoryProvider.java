package com.github.fabriciolfj.providers.database;

import com.github.fabriciolfj.business.FindLastExtract;
import com.github.fabriciolfj.business.SaveExtract;
import com.github.fabriciolfj.entities.ExtractEntity;
import com.github.fabriciolfj.exceptions.ExtractException;
import com.github.fabriciolfj.providers.database.converter.ExtractDataConverter;
import com.github.fabriciolfj.providers.database.model.ExtractData;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class ExtractRepositoryProvider implements SaveExtract, FindLastExtract {

    private final AccountRepositoryProvider accountRepositoryProvider;

    @Override
    public Uni<ExtractEntity> find(final String account) {
        return queryLastExtract(account)
                .onItem().ifNull().failWith(new ExtractException("Extract not found to account: " + account))
                .onItem()
                .transform(value -> ExtractDataConverter.toEntity(value));
    }

    @Override
    public Uni<ExtractEntity> save(final ExtractEntity entity, final String account) {
        return accountRepositoryProvider.findDataByCode(account)
                .onItem()
                .transform(v -> ExtractDataConverter.toData(entity, v))
                .flatMap(p -> Panache.withTransaction(p::persist))
                .onItem()
                .transform(result -> ExtractDataConverter.toEntity((ExtractData) result));
    }

    private Uni<ExtractData> queryLastExtract(String account) {
        return ExtractData.find(
                        "Select e From ExtractData e where e.dataMov = " +
                                "(select max(p.dataMov) from ExtractData p join p.accountData b " +
                                "where b.code =?1 )", account)
                .firstResult();
    }
}
