package org.ofavor.sbd.order.interfaces.rest;

import org.ofavor.sbd.order.domain.exception.Exception;
import org.ofavor.sbd.order.interfaces.response.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception ex) {
        return Response.error(ex.getCode(), ex.getMessage());
    }
}
