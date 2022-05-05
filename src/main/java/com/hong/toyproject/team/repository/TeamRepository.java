package com.hong.toyproject.team.repository;

import com.hong.toyproject.team.Team;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long>, TeamRepositoryDsl {

    @Override
    Optional<Team> findById(Long teamId);
}
