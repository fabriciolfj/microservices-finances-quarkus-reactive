package com.github.fabriciolfj.business.usecase;

import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@ApplicationScoped
@RequiredArgsConstructor
public class ProcessWithdrawal {

    private final WithDrawCase withDrawCase;
    private final ChargeFeeCase chargeFeeCase;
    private static final BigDecimal TAXA = BigDecimal.valueOf(1.99);

    public Uni<Object> execute(final String account, final BigDecimal value) {
        return withDrawCase.execute(account, value)
                .flatMap(c ->  chargeFeeCase.execute(account))
                .flatMap(l -> {
                    if (l.getWithdrawalAmount() <= 0) {
                        return  withDrawCase.execute(account, TAXA);
                    }

                    return Uni.createFrom().voidItem();
                });
    }
}