package com.github.fabriciolfj.controllers.converters;

import com.github.fabriciolfj.controllers.dto.AccountCreateRequestDTO;
import com.github.fabriciolfj.entities.AccountEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class AccountRequestConverter {

    private AccountRequestConverter() { }

    public static AccountEntity toEntity(final AccountCreateRequestDTO dto) {
        return AccountEntity
                .builder()
                .balance(dto.getEntrance())
                .code(UUID.randomUUID().toString())
                .dateMov(LocalDateTime.now())
                .build();
    }
}
