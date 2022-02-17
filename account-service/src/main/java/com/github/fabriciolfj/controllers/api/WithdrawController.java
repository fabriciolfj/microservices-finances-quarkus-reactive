package com.github.fabriciolfj.controllers.api;

import com.github.fabriciolfj.business.usecase.ChargeFeeCase;
import com.github.fabriciolfj.business.usecase.DepositCase;
import com.github.fabriciolfj.business.usecase.ProcessWithdrawal;
import com.github.fabriciolfj.business.usecase.WithDrawCase;
import com.github.fabriciolfj.controllers.dto.WithdrawDTO;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Consumes("application/json")
@Produces("application/json")
@Path("/api/v1/withdraw")
@RequiredArgsConstructor
public class WithdrawController {

    private final DepositCase depositCase;
    private final ProcessWithdrawal processWithdrawal;

    @POST
    @Path("/credit")
    public Uni<Void> depositCredit(final WithdrawDTO dto) {
        return depositCase.execute(dto.getAccount(), dto.getValue())
                .flatMap(v -> Uni.createFrom().voidItem());
    }

    @POST
    @Path("/debit")
    public Uni<Void> withdrawDebit(final WithdrawDTO dto) {
        return processWithdrawal.execute(dto.getAccount(), dto.getValue())
                .flatMap(v -> Uni.createFrom().voidItem());
    }
}
