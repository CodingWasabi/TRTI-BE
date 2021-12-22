package com.codingwasabi.trti.domain.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Period {
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime created;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
