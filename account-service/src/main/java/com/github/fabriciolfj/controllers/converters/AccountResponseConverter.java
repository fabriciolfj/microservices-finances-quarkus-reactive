package com.github.fabriciolfj.controllers.converters;

import com.github.fabriciolfj.controllers.dto.AccountGetResponse;
import com.github.fabriciolfj.entities.AccountEntity;

public class AccountResponseConverter {

    private AccountResponseConverter() { }

    public static AccountGetResponse toDto(final AccountEntity entity) {
        return AccountGetResponse
                .builder()
                .code(entity.getCode())
                .balance(entity.getBalance())
                .dataMov(entity.getDateMov())
                .build();
    }
}
