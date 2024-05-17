package com.github.fabriciolfj.controllers.api;

import com.github.fabriciolfj.business.usecase.CreateAccountUseCase;
import com.github.fabriciolfj.business.usecase.GetAccountByCodeUseCase;
import com.github.fabriciolfj.business.usecase.GetAllAccountsUseCase;
import com.github.fabriciolfj.controllers.converters.AccountRequestConverter;
import com.github.fabriciolfj.controllers.converters.AccountResponseConverter;
import com.github.fabriciolfj.controllers.dto.AccountCreateRequestDTO;
import com.github.fabriciolfj.controllers.dto.AccountCreateResponse;
import com.github.fabriciolfj.controllers.dto.AccountGetResponse;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;

@Consumes("application/json")
@Produces("application/json")
@Path("api/v1/account")
@ApplicationScoped
@RequiredArgsConstructor
public class AccountController {

    private final CreateAccountUseCase useCase;
    private final GetAllAccountsUseCase getAllUseCase;
    private final GetAccountByCodeUseCase getAccountByCodeUseCase;

    @POST
    public Uni<AccountCreateResponse> createAccount(final AccountCreateRequestDTO dto) {
        return Uni.createFrom().item(AccountRequestConverter.toEntity(dto))
                .onItem().transform(useCase::execute)
                .flatMap(uni -> uni.onItem().transform(AccountCreateResponse::new));
    }

    @GET
    public Multi<AccountGetResponse> findAll() {
        return getAllUseCase.execute().onItem().transform(AccountResponseConverter::toDto);
    }

    @GET
    @Path("{code}")
    public Uni<AccountGetResponse> find(@PathParam("code") final String code) {
        return getAccountByCodeUseCase.execute(code)
                .onItem().transform(AccountResponseConverter::toDto);
    }
}
