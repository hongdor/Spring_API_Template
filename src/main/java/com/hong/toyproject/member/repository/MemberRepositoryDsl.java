package com.hong.toyproject.member.repository;

import com.hong.toyproject.member.Member;
import com.hong.toyproject.member.dto.MemberDto;
import com.hong.toyproject.member.dto.MemberSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberRepositoryDsl {
    public Member findAllMemberDsl();
    public Page<MemberDto> findPages(Pageable pageable, MemberSearchDto memberSearchDto);
}
