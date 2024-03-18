package com.erlanggariansyah.articlemanagement.util;

import com.erlanggariansyah.articlemanagement.constant.FieldConstant;
import com.erlanggariansyah.articlemanagement.constant.GeneralConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseUtil {
    public static ResponseEntity<?> ok() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(GeneralConstant.STATUS, HttpStatus.OK.value());
        body.put(GeneralConstant.MESSAGE, HttpStatus.OK);

        return ResponseEntity.ok(body);
    }

    public static ResponseEntity<?> ok(Object data) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(GeneralConstant.STATUS, HttpStatus.OK.value());
        body.put(GeneralConstant.MESSAGE, HttpStatus.OK);
        body.put(GeneralConstant.DATA, data);

        return ResponseEntity.ok(body);
    }

    public static ResponseEntity<?> badRequest(String field, String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        Map<String, String> bodyData = new LinkedHashMap<>();

        bodyData.put(FieldConstant.FIELD, field);
        bodyData.put(FieldConstant.MESSAGE, message);

        body.put(GeneralConstant.STATUS, HttpStatus.BAD_REQUEST.value());
        body.put(GeneralConstant.MESSAGE, HttpStatus.BAD_REQUEST);
        body.put(GeneralConstant.DATA, bodyData);

        return ResponseEntity.badRequest().body(body);
    }

    public static ResponseEntity<?> notFound(String field, String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        Map<String, String> bodyData = new LinkedHashMap<>();

        bodyData.put(FieldConstant.FIELD, field);
        bodyData.put(FieldConstant.MESSAGE, message);

        body.put(GeneralConstant.STATUS, HttpStatus.NOT_FOUND.value());
        body.put(GeneralConstant.MESSAGE, HttpStatus.NOT_FOUND);
        body.put(GeneralConstant.DATA, bodyData);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
