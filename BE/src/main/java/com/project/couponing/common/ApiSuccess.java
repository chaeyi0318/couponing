package com.project.couponing.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApiSuccess<T> {
    private int code;
    private String message;
    private T data;

    public static <T> ApiSuccess<T> of(HttpStatus status, String message, T data) {
        return new ApiSuccess<>(status.value(), message, data);
    }

    public static ApiSuccess<Void> ok(String message) {
        return new ApiSuccess<>(HttpStatus.OK.value(), message, null);
    }
}
