package com.codingwasabi.trti.domain.memberInGroup.model;

import com.codingwasabi.trti.domain.group.model.Group;
import com.codingwasabi.trti.domain.member.model.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class MemberInGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
