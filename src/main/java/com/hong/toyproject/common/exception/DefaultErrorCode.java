package com.hong.toyproject.common.exception;

import com.hong.toyproject.common.exception.ErrorCode;

public enum DefaultErrorCode implements ErrorCode {
    DEFAULT_ERROR_CODE(500, "DEFAULT", "Unknown Error");

    private final String code;
    private final String message;
    private final int status;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    DefaultErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
