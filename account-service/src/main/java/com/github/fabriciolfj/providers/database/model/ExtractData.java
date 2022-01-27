package com.github.fabriciolfj.providers.database.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "extrato")
public class ExtractData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private BigDecimal entrance;
    private BigDecimal exit;
    private BigDecimal balance;
    @Column(name = "dataMov", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataMov;
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private AccountData accountData;
}
