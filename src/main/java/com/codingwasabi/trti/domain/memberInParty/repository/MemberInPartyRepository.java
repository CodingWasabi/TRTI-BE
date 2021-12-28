package com.codingwasabi.trti.domain.memberInParty.repository;

import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.memberInParty.model.MemberInParty;
import com.codingwasabi.trti.domain.party.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberInPartyRepository extends JpaRepository<MemberInParty, Long> {
    Integer countByParty(Party party);

    List<MemberInParty> findAllByParty(Party party);

    List<MemberInParty> findAllByMember(Member member);
}
