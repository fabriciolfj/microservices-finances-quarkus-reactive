package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.FindCache;
import com.github.fabriciolfj.business.FindLastExtract;
import com.github.fabriciolfj.business.UpdateCache;
import com.github.fabriciolfj.entities.LimitAccountEntity;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class ChargeFeeCase {

    private final FindCache findCache;
    private final UpdateCache updateCache;
    private final FindLastExtract findLastExtract;

    public Uni<LimitAccountEntity> execute(final String account) {
        return findCache.getCache(account)
                .onItem()
                .transform(c -> c.decrementWithdrawal())
                .flatMap(limit -> updateCache.update(limit));
    }
}
