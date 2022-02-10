package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.business.usecase.CreateLimit;
import com.github.fabriciolfj.business.usecase.FindLimit;
import com.github.fabriciolfj.business.usecase.FindLimitsAccount;
import com.github.fabriciolfj.controller.dto.LimitResponseConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@ApplicationScoped
@Path("/api/v1/limits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LimitController {

    private final CreateLimit createLimit;
    private final FindLimitsAccount findLimitsAccount;

    @POST
    @Path("/{account}/{balance}")
    public Response createLimit(@PathParam("account") final String account, @PathParam("balance") final BigDecimal balance) {
        log.info("Request acocunt: {}, balance: {}", account, balance);
        var limit = createLimit.execute(account, balance);
        return Response.accepted().entity(LimitResponseConverter.toResponse(limit))
                .build();
    }

    @GET
    @Path("/{account}")
    public Response findLimits(@PathParam("account") final String account) {
        var limits = findLimitsAccount.findPerAccount(account);
        var responses = limits.stream().map(LimitResponseConverter::toResponse).toList();
        return Response.accepted().entity(responses).build();
    }
}
