package com.github.fabriciolfj.providers.http;

import com.github.fabriciolfj.exceptions.LimitException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.Response;

@Slf4j
public class LimitClientException implements ResponseExceptionMapper<LimitException> {

    @Override
    public LimitException toThrowable(Response response) {
        log.info("Response: {}", response);
        return new LimitException("Failed to retrieve limit");
    }
}
