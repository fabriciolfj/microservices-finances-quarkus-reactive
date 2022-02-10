package com.github.fabriciolfj.providers;

import com.github.fabriciolfj.business.CreateLimit;
import com.github.fabriciolfj.providers.http.LimitClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@ApplicationScoped
public class LimitProvider implements CreateLimit {

    @RestClient
    private LimitClient client;

    @Override
    public void create(final String account, final BigDecimal balance) {
        client.create(account, balance);
    }
}
