package com.github.fabriciolfj.providers.http;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.math.BigDecimal;

@Path("/api/v1/limits")
@Produces("application/json")
@RegisterRestClient(configKey = "limit-service")
@RegisterProvider(LimitClientException.class)
public interface LimitClient {

    @POST
    @Path("/{account}/{balance}")
    void create(@PathParam("account") final String account, @PathParam("balance") final BigDecimal bigDecimal);
}
