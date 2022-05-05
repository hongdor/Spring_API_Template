package com.hong.toyproject.member;

import com.hong.toyproject.member.dto.MemberCreateDto;
import com.hong.toyproject.member.dto.MemberSearchDto;
import com.hong.toyproject.member.dto.MemberUpdateDto;
import com.hong.toyproject.member.exception.MemberNotFoundException;
import com.hong.toyproject.member.repository.MemberRepository;
import com.hong.toyproject.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    @GetMapping("/api/v1/members")
    public List<MemberDto> findAllMembers(){
        List<Member> members = this.memberService.findAllMembers();
        return MemberDto.membersToMemberDtos(members);
    }

    @GetMapping("/api/v1/members/{memberId}")
    public MemberDto findOneMember(@PathVariable Long memberId){
        Member member = this.memberService.findOneMember(memberId);
        return MemberDto.memberToMemberDto(member);
    }

    @GetMapping("/api/v1/teams/{teamId}/members")
    public List<MemberDto> findMembersOfOneTeam(@PathVariable Long teamId){
        List<Member> members = this.memberService.findMembersOfOneTeam(teamId);
        return MemberDto.membersToMemberDtos(members);
    }

    @GetMapping("/api/v1/members/pages")
    public Page<MemberDto> findPages(Pageable pageable, MemberSearchDto memberSearchDto){
        return this.memberRepository.findPages(pageable, memberSearchDto);
    }

    @PostMapping("/api/v1/members")
    public MemberDto createMember(@RequestBody MemberCreateDto memberCreateDto) {
        Member newMember = this.memberService.createMember(memberCreateDto);
        return MemberDto.memberToMemberDto(newMember);
    }

    @Transactional
    @PutMapping("/api/v1/members/{memberId}")
    public MemberDto updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateDto memberUpdateDto) {
        Member updatedMember = this.memberService.updateMember(memberId, memberUpdateDto);
        return MemberDto.memberToMemberDto(updatedMember);
    }

    @DeleteMapping("/api/v1/members/{memberId}")
    void deleteMember(@PathVariable Long memberId) {
        this.memberService.deleteMember(memberId);
    }
}
