package com.github.fabriciolfj.controllers.converters;

import com.github.fabriciolfj.controllers.dto.AccountCreateRequestDTO;
import com.github.fabriciolfj.entities.AccountEntity;
import com.github.fabriciolfj.entities.ExtractEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

public class AccountRequestConverter {

    private AccountRequestConverter() { }

    public static AccountEntity toEntity(final AccountCreateRequestDTO dto) {
        final var extract = ExtractEntity
                .builder()
                .entrance(dto.getEntrance())
                .balance(dto.getEntrance())
                .code(UUID.randomUUID().toString())
                .exit(BigDecimal.ZERO)
                .dateMov(LocalDateTime.now())
                .build();

        return AccountEntity
                .builder()
                .balance(dto.getEntrance())
                .code(UUID.randomUUID().toString())
                .dateMov(LocalDateTime.now())
                .extracts(Arrays.asList(extract))
                .build();
    }
}
