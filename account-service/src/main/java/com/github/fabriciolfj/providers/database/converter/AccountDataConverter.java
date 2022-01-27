package com.github.fabriciolfj.providers.database.converter;

import com.github.fabriciolfj.entities.AccountEntity;
import com.github.fabriciolfj.providers.database.model.AccountData;

import java.util.stream.Collectors;

public class AccountDataConverter {

    private AccountDataConverter() {}

    public static final AccountEntity toEntity(final AccountData accountData) {
        final var extracts = accountData.getExtractData().stream().map(ExtractDataConverter::toEntity).collect(Collectors.toList());

        return AccountEntity
                .builder()
                .code(accountData.getCode())
                .dateMov(accountData.getDataMov())
                .balance(accountData.getBalance())
                .extracts(extracts)
                .build();
    }

    public static final AccountData toData(final AccountEntity accountEntity) {
        final var accountData = AccountData
                .builder()
                .balance(accountEntity.getBalance())
                .code(accountEntity.getCode())
                .dataMov(accountEntity.getDateMov())
                .build();

        final var extracts = accountEntity
                .getExtracts()
                .stream()
                .map(v -> ExtractDataConverter.toData(v, accountData))
                .collect(Collectors.toList());

        accountData.setExtractData(extracts);
        return accountData;
    }
}
