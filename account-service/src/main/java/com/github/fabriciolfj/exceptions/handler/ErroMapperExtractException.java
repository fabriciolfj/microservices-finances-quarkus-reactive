package com.github.fabriciolfj.exceptions.handler;

import com.github.fabriciolfj.exceptions.ExtractException;
import org.apache.http.HttpStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ErroMapperExtractException implements ExceptionMapper<ExtractException> {

    @Override
    public Response toResponse(ExtractException e) {
        return Response.status(HttpStatus.SC_BAD_REQUEST)
                .entity(e.getMessage())
                .build();
    }
}
