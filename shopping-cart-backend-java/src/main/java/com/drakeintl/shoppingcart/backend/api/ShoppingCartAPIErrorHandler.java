package com.drakeintl.shoppingcart.backend.api;

import com.drakeintl.shoppingcart.backend.service.ShoppingCart;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ShoppingCartAPIErrorHandler extends ResponseEntityExceptionHandler {

    /**
     * in case of frontend errors, or simultaneous orders
     *
     * @param exception the exception that we caught
     * @param request we need this for the built-in framework requirement
     * @return
     */
    @ExceptionHandler(value = ShoppingCart.OrderFailure.class)
    protected ResponseEntity<Object> handleOrderFailure(ShoppingCart.OrderFailure exception, WebRequest request) {
        return handleExceptionInternal(exception, "[]", new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
