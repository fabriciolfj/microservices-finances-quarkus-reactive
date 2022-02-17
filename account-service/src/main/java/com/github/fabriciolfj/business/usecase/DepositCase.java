package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.FindLastExtract;
import com.github.fabriciolfj.business.SaveExtract;
import com.github.fabriciolfj.entities.ExtractEntity;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@ApplicationScoped
@RequiredArgsConstructor
public class DepositCase {

    private final FindLastExtract findLastExtract;
    private final SaveExtract saveExtract;

    public Uni<ExtractEntity> execute(final String account, final BigDecimal value) {
        return findLastExtract.find(account)
                .onItem().transform(e -> e.calculateCredit(value))
                .flatMap(result -> saveExtract.save(result, account));
    }
}
