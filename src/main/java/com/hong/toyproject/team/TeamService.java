package com.hong.toyproject.team;

import com.hong.toyproject.member.dto.MemberDto;
import com.hong.toyproject.team.dto.TeamDto;
import com.hong.toyproject.team.exception.TeamNotFoundException;
import com.hong.toyproject.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Team findOneTeam(Long teamId){
        return this.teamRepository.findById(teamId).orElseThrow(TeamNotFoundException::new);
    }

}
