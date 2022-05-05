package com.hong.toyproject.member.exception;

import com.hong.toyproject.common.exception.CustomException;
import com.hong.toyproject.common.exception.ErrorCode;

public class MemberNotFoundException extends CustomException {
    public MemberNotFoundException(){
        super(MemberErrorCode.MEMBER_NOT_FOUND);
    }

    public MemberNotFoundException(ErrorCode errorCode){
        super(errorCode);
    }
}
