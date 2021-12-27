package com.codingwasabi.trti.domain.memberInParty.model;

import com.codingwasabi.trti.domain.party.model.Party;
import com.codingwasabi.trti.domain.member.model.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class MemberInParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Party party;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
