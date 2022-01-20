package com.github.fabriciolfj.providers.database.converter;

import com.github.fabriciolfj.entities.AccountEntity;
import com.github.fabriciolfj.providers.database.model.AccountData;

public class AccountDataConverter {

    private AccountDataConverter() {}

    public static final AccountEntity toEntity(final AccountData accountData) {
        return AccountEntity
                .builder()
                .code(accountData.getCode())
                .dateMov(accountData.getDataMov())
                .balance(accountData.getBalance())
                .build();
    }

    public static final AccountData toData(final AccountEntity accountEntity) {
        final var data = AccountData
                .builder()
                .balance(accountEntity.getBalance())
                .code(accountEntity.getCode())
                .dataMov(accountEntity.getDateMov())
                .build();

        return data;
    }
}
