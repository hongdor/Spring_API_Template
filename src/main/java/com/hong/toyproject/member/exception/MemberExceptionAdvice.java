package com.hong.toyproject.member.exception;

import com.hong.toyproject.common.exception.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MemberExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(MemberExceptionAdvice.class);

    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse MemberNotFoundHandler(MemberNotFoundException exception){
        logger.error("MemberNotFoundException", exception);
        return new ErrorResponse(exception);
    }
}
