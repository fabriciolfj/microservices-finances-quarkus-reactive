package com.github.fabriciolfj.controllers.converters;

import com.github.fabriciolfj.controllers.dto.ExtractGetResponse;
import com.github.fabriciolfj.entities.ExtractEntity;

public class ExtractResponseConverter {

    private ExtractResponseConverter() { }

    public static ExtractGetResponse toResponse(final ExtractEntity entity) {
        return ExtractGetResponse
                .builder()
                .code(entity.getCode())
                .balance(entity.getBalance())
                .dataMov(entity.getDateMov())
                .entrance(entity.getEntrance())
                .exit(entity.getExit())
                .build();
    }
}
