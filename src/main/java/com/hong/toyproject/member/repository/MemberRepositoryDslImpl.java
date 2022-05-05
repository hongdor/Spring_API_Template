package com.hong.toyproject.member.repository;

import com.hong.toyproject.member.Member;
import com.hong.toyproject.member.dto.MemberDto;
import com.hong.toyproject.member.dto.MemberSearchDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

import static com.hong.toyproject.common.QClassConfig.*;



public class MemberRepositoryDslImpl implements MemberRepositoryDsl {


    private final EntityManager em;
    private JPAQueryFactory queryFactory;

    public MemberRepositoryDslImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Member findAllMemberDsl(){
        return queryFactory
                .select(member)
                .from(member)
                .fetchFirst();
    }

    @Override
    public Page<MemberDto> findPages(Pageable pageable, MemberSearchDto memberSearchDto) {
        List<Member> members = queryFactory
                .select(member)
                .from(member)
                .leftJoin(member.team, team)
                .fetchJoin()
                .where(
                        eqMemberId(memberSearchDto.getMemberId()),
                        containsName(memberSearchDto.getName())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        List<MemberDto> memberDtos = members.stream()
                .map(member -> {
                    MemberDto memberDto = MemberDto.memberToMemberDto(member);
                    memberDto.setTeam(member.getTeam());
                    return memberDto;
                })
                .collect(Collectors.toList());

        return PageableExecutionUtils.getPage(memberDtos, pageable, members::size);
    }

    private BooleanExpression eqMemberId(Long memberId){
        return memberId == null ? null : member.memberId.eq(memberId);
    }

    private BooleanExpression containsName(String name){
        return name == null ? null : member.name.contains(name);
    }
}
