package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.ExtractEntity;
import io.smallrye.mutiny.Uni;

public interface SaveExtract {

    Uni<ExtractEntity> save(final ExtractEntity entity, final String account);
}
