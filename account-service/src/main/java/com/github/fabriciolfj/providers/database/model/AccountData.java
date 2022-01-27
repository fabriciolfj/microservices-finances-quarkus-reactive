package com.github.fabriciolfj.providers.database.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "accountData")
    private List<ExtractData> extractData;
}
