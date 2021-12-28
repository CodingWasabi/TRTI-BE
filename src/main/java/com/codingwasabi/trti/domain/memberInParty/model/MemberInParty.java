package com.codingwasabi.trti.domain.memberInParty.model;

import com.codingwasabi.trti.domain.party.model.Party;
import com.codingwasabi.trti.domain.member.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberInParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Party party;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public static MemberInParty of(Party party, Member member) {
        return MemberInParty.builder()
                .party(party)
                .member(member)
                .build();
    }
}
