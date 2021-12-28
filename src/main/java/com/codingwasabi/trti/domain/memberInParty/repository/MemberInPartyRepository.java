package com.codingwasabi.trti.domain.memberInParty.repository;

import com.codingwasabi.trti.domain.memberInParty.model.MemberInParty;
import com.codingwasabi.trti.domain.party.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInPartyRepository extends JpaRepository<MemberInParty, Long> {
    Integer countByParty(Party party);
}
