package com.hong.toyproject.team.exception;

import com.hong.toyproject.common.exception.CustomException;

public class TeamNotFoundException extends CustomException {
    public TeamNotFoundException(){
        super(TeamErrorCode.TEAM_NOT_FOUND);
    }
}