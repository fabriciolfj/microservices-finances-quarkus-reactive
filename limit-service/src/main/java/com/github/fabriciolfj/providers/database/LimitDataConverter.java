package com.github.fabriciolfj.providers.database;

import com.github.fabriciolfj.entity.LimitAccountEntity;

public class LimitDataConverter {

    private LimitDataConverter() { }

    public static LimitData toData(final LimitAccountEntity limitAccountEntity) {
        return LimitData
                .builder()
                .account(limitAccountEntity.getAccount())
                .dataMov(limitAccountEntity.getDataMov())
                .rate(limitAccountEntity.getRate())
                .withdrawalAmount(limitAccountEntity.getWithdrawalAmount())
                .build();
    }

    public static LimitAccountEntity toEntities(final LimitData data) {
        return LimitAccountEntity
                .builder()
                .dataMov(data.getDataMov())
                .account(data.getAccount())
                .rate(data.getRate())
                .withdrawalAmount(data.getWithdrawalAmount())
                .build();
    }
}
