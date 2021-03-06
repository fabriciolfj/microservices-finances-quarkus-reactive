package com.github.fabriciolfj.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountGetResponse {

    private String code;
    private BigDecimal balance;
    private LocalDateTime dataMov;
    private List<ExtractGetResponse> extracts;
}
