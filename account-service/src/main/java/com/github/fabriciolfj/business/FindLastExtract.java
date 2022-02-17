package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.ExtractEntity;
import io.smallrye.mutiny.Uni;

public interface FindLastExtract {

    Uni<ExtractEntity> find(final String account);
}
