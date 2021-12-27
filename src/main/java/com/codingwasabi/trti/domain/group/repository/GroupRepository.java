package com.codingwasabi.trti.domain.group.repository;

import com.codingwasabi.trti.domain.group.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
