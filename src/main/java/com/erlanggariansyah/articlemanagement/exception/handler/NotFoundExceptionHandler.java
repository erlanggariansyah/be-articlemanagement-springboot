package com.erlanggariansyah.articlemanagement.exception.handler;

import com.erlanggariansyah.articlemanagement.exception.throwable.NotFoundException;
import com.erlanggariansyah.articlemanagement.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handle(NotFoundException exception) {
        return ResponseUtil.notFound(exception.getField(), exception.getMessage());
    }
}
