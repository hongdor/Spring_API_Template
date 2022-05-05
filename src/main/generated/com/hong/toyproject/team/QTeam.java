package com.hong.toyproject.team;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeam is a Querydsl query type for Team
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeam extends EntityPathBase<Team> {

    private static final long serialVersionUID = 90456892L;

    public static final QTeam team = new QTeam("team");

    public final ListPath<com.hong.toyproject.member.Member, com.hong.toyproject.member.QMember> members = this.<com.hong.toyproject.member.Member, com.hong.toyproject.member.QMember>createList("members", com.hong.toyproject.member.Member.class, com.hong.toyproject.member.QMember.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final NumberPath<Long> teamId = createNumber("teamId", Long.class);

    public QTeam(String variable) {
        super(Team.class, forVariable(variable));
    }

    public QTeam(Path<? extends Team> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTeam(PathMetadata metadata) {
        super(Team.class, metadata);
    }

}

