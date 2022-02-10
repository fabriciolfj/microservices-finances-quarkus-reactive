package com.github.fabriciolfj.providers.database;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "limits")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LimitData {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dataMov", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataMov;
    private String account;
    private Integer withdrawalAmount;
    private BigDecimal rate;
}
