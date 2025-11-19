package com.project.couponing.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
public enum ApiErrorCode {
    NO_STOCK(HttpStatus.BAD_REQUEST, "NO_STOCK", "쿠폰 재고가 없습니다."),
    ALREADY_ISSUED(HttpStatus.CONFLICT, "ALREADY_ISSUED", "이미 발급받은 쿠폰입니다."),
    EVENT_NOT_FOUND(HttpStatus.NOT_FOUND, "EVENT_NOT_FOUND", "이벤트를 찾을 수 없습니다."),
    EVENT_NOT_OPEN(HttpStatus.BAD_REQUEST, "EVENT_NOT_OPEN", "현재 발급이 불가능한 이벤트입니다."),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "INVALID_REQUEST", "잘못된 요청입니다."),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_ERROR", "서버 오류가 발생했습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_NOT_FOUND", "해당 유저를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ApiErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
