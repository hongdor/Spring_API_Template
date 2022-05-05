package com.hong.toyproject.team.exception;

import com.hong.toyproject.common.exception.ErrorCode;

public enum TeamErrorCode implements ErrorCode {
    INVALID_PARAMETER(400, "T001", "Invalid Request Data"),
    TEAM_NOT_FOUND(404, "C002", "Team Not Found");

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

    TeamErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
