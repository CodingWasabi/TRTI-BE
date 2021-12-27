package com.codingwasabi.trti.domain.party.repository;

import com.codingwasabi.trti.domain.party.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Party, Long> {
}
