package com.github.fabriciolfj.providers.database.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "conta")
public class AccountData extends PanacheEntity{

    @Column(name = "code")
    private String code;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "dataMov", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataMov;
}
