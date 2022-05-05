package com.hong.toyproject.member;

import com.hong.toyproject.member.Member;
import com.hong.toyproject.member.dto.MemberCreateDto;
import com.hong.toyproject.member.dto.MemberDto;
import com.hong.toyproject.member.dto.MemberUpdateDto;
import com.hong.toyproject.member.exception.MemberNotFoundException;
import com.hong.toyproject.member.repository.MemberRepository;
import com.hong.toyproject.team.Team;
import com.hong.toyproject.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamService teamService;

    public List<Member> findAllMembers(){
        return this.memberRepository.findAll();
    }

    public Member findOneMember(Long memberId){

        return this.memberRepository.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);
    }

    public List<Member> findMembersOfOneTeam(Long teamId){

        Team team = this.teamService.findOneTeam(teamId);

        return this.memberRepository.findAllByTeam(team);
    }

    public Member createMember(MemberCreateDto memberCreateDto){

        Member member = memberCreateDto.toMember();
        this.setTeamOfMember(member, memberCreateDto.getTeamId());

        return this.memberRepository.save(member);
    }

    public Member updateMember(Long memberId, MemberUpdateDto memberUpdateDto){
        Member member = this.memberRepository.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);

        member.update(memberUpdateDto);
        this.setTeamOfMember(member, memberUpdateDto.getTeamId());

        return member;
    }

    public void deleteMember(Long memberId){

        Member member = this.memberRepository.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);

        this.memberRepository.delete(member);
    }

    public void setTeamOfMember(Member member, Long teamId){
        if(teamId != null){
            Team team = this.teamService.findOneTeam(teamId);
            member.setTeam(team);
        }
    }
}
