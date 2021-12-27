package com.codingwasabi.trti.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MemberAPI {
    OAUTH_LOGIN("LOGIN"),
    OAUTH_JOIN("JOIN");

    private String message;
}
