package com.hong.toyproject.team.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class TeamRepositoryDslImpl implements TeamRepositoryDsl{

    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    public TeamRepositoryDslImpl(EntityManager em) {
        this.em = em;
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }
}
