package com.codingwasabi.trti.domain.memberInParty.repository;

import com.codingwasabi.trti.domain.memberInParty.model.MemberInParty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInGroupRepository extends JpaRepository<MemberInParty, Long> {
}
