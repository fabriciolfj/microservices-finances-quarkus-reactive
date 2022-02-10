package com.github.fabriciolfj.providers.database;

import com.github.fabriciolfj.business.FindExtractLimitAccount;
import com.github.fabriciolfj.business.LimitSave;
import com.github.fabriciolfj.entity.LimitAccountEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LimiteRepository implements PanacheRepository<LimitData>, FindExtractLimitAccount, LimitSave {

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void save(final LimitAccountEntity entity) {
        persist(LimitDataConverter.toData(entity));
    }

    @Override
    public List<LimitAccountEntity> findAllPerAccount(String account) {
        return find("account", Sort.ascending("dataMov"), account)
                .stream()
                .map(LimitDataConverter::toEntities)
                .toList();
    }
}
