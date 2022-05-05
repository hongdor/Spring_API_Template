package com.hong.toyproject.member.repository;


import com.hong.toyproject.member.Member;
import com.hong.toyproject.team.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryDsl {
    Page<Member> findByOrderByMemberIdDesc(Pageable pageable);
    Page<Member> findByOrderByMemberIdAsc(Pageable pageable);
    List<Member> findAllByTeam(Team team);

    @Override
    Optional<Member> findById(Long memberId);
}
