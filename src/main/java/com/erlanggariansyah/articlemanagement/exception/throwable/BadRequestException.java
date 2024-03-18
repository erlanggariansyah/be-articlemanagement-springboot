package com.erlanggariansyah.articlemanagement.exception.throwable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BadRequestException extends Throwable {
    private String field;
    private String message;
}
