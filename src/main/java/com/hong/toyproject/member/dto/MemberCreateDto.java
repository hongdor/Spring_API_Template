package com.hong.toyproject.member.dto;

import com.hong.toyproject.member.Member;
import lombok.Getter;

@Getter
public class MemberCreateDto {

    private String name;
    private Long teamId;

    public Member toMember(){
        return Member.builder()
                .name(this.name)
                .build();
    }

}
