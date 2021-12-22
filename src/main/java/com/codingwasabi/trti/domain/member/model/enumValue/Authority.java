package com.codingwasabi.trti.domain.member.model.enumValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Authority {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private String role;
}
