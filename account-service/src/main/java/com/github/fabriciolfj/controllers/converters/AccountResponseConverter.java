package com.github.fabriciolfj.controllers.converters;

import com.github.fabriciolfj.controllers.dto.AccountGetResponse;
import com.github.fabriciolfj.entities.AccountEntity;

import java.util.stream.Collectors;

public class AccountResponseConverter {

    private AccountResponseConverter() { }

    public static AccountGetResponse toDto(final AccountEntity entity) {
        final var extracts = entity.getExtracts().stream().map(ExtractResponseConverter::toResponse)
                .collect(Collectors.toList());

        return AccountGetResponse
                .builder()
                .extracts(extracts)
                .code(entity.getCode())
                .balance(entity.getBalance())
                .dataMov(entity.getDateMov())
                .build();
    }
}
