package com.erlanggariansyah.articlemanagement.exception.handler;

import com.erlanggariansyah.articlemanagement.exception.throwable.BadRequestException;
import com.erlanggariansyah.articlemanagement.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BadRequestExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handle(BadRequestException badRequestException) {
        return ResponseUtil.badRequest(badRequestException.getField(), badRequestException.getMessage());
    }
}
