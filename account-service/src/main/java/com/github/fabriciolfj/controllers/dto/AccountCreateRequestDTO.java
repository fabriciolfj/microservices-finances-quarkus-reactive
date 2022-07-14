package com.github.fabriciolfj.controllers.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class AccountCreateRequestDTO {

    @NotNull(message = "Balance not found")
    private BigDecimal entrance;
}
