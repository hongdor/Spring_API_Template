package com.hong.toyproject.member.dto;

import com.hong.toyproject.member.Member;
import com.hong.toyproject.team.Team;
import com.hong.toyproject.team.dto.TeamDto;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
public class MemberDto {

    private Long memberId;
    private String name;
    private TeamDto team;

    private MemberDto(Member member) {
        this.memberId = member.getMemberId();
        this.name = member.getName();
    }

    public void setTeam(Team team){
        if(team != null)
            this.team = TeamDto.teamToTeamDto(team);
    }

    public static List<MemberDto> membersToMemberDtos(List<Member> members){
        return members.stream()
                .map(MemberDto::new)
                .collect(Collectors.toList());
    }
    public static MemberDto memberToMemberDto(Member member){
        return new MemberDto(member);
    }
}
