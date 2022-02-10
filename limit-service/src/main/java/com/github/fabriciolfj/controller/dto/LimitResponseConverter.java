package com.github.fabriciolfj.controller.dto;

import com.github.fabriciolfj.entity.LimitAccountEntity;

public class LimitResponseConverter {

    private LimitResponseConverter() { }

    public static final LimitResponse toResponse(final LimitAccountEntity entity) {
        return LimitResponse.builder()
                .account(entity.getAccount())
                .dataMov(entity.getDataMov())
                .rate(entity.getRate())
                .withdrawalAmount(entity.getWithdrawalAmount())
                .build();
    }
}
