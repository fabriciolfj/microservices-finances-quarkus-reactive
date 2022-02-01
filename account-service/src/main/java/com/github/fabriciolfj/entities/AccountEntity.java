package com.github.fabriciolfj.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity implements CommandEntity {

    private String code;
    private BigDecimal balance;
    private LocalDateTime dateMov;
    private List<ExtractEntity> extracts;
    private StatusEntity statusEntity;

    @Override
    public StatusEntity findStatus() {
        return statusEntity;
    }

    @Override
    public CommandEntity updateStatus(final StatusEntity statusEntity) {
        this.statusEntity = statusEntity;
        return this;
    }
}
