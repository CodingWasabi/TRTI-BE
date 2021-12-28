package com.codingwasabi.trti.domain.result.repository;

import com.codingwasabi.trti.domain.result.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
}
