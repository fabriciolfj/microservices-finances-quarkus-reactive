package com.github.fabriciolfj.providers.database.converter;

import com.github.fabriciolfj.entities.ExtractEntity;
import com.github.fabriciolfj.providers.database.model.AccountData;
import com.github.fabriciolfj.providers.database.model.ExtractData;

public class ExtractDataConverter {

    private ExtractDataConverter() { }

    public static ExtractEntity toEntity(final ExtractData data) {
        return ExtractEntity
                .builder()
                .dateMov(data.getDataMov())
                .exit(data.getExit())
                .code(data.getCode())
                .balance(data.getBalance())
                .entrance(data.getEntrance())
                .build();
    }

    public static ExtractData toData(final ExtractEntity entity, final AccountData accountData) {
        return ExtractData.builder()
                .code(entity.getCode())
                .dataMov(entity.getDateMov())
                .accountData(accountData)
                .exit(entity.getExit())
                .balance(entity.getBalance())
                .entrance(entity.getEntrance())
                .build();
    }
}
