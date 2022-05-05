package com.hong.toyproject.team;

import com.hong.toyproject.team.repository.TeamRepository;
import com.hong.toyproject.team.dto.TeamDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamRepository teamRepository;
    private final TeamService teamService;
    private static final Logger log = LoggerFactory.getLogger(TeamController.class);

}
