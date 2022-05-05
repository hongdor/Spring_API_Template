package com.hong.toyproject.team.exception;

import com.hong.toyproject.common.exception.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class TeamExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(TeamExceptionAdvice.class);

    @ExceptionHandler(TeamNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse TeamNotFoundHandler(TeamNotFoundException exception){
        logger.error("TeamNotFoundException", exception);
        return new ErrorResponse(exception);
    }
}
