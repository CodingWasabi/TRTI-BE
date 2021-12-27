package com.codingwasabi.trti.domain.member.model.enumValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MemberAuthMessage {
    OAUTH_LOGIN("LOGIN"),
    OAUTH_JOIN("JOIN");

    private String message;
}
