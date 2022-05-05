package com.hong.toyproject.team.dto;

import com.hong.toyproject.member.Member;
import com.hong.toyproject.member.dto.MemberDto;
import com.hong.toyproject.team.Team;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
public class TeamDto {
    private Long teamId;
    private String name;
    private List<MemberDto> members = new ArrayList<>();

    public TeamDto(Team team) {
        this.teamId = team.getTeamId();
        this.name = team.getName();
    }

    public void setMembers(List<MemberDto> members) {
        this.members = members;
    }

    public static List<TeamDto> teamsToTeamDtos(List<Team> teams){
        return teams.stream()
                .map(TeamDto::new)
                .collect(Collectors.toList());
    }
    public static TeamDto teamToTeamDto(Team team){
        return new TeamDto(team);
    }
}
