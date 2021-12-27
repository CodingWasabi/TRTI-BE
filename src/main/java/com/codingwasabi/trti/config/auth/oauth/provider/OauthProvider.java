package com.codingwasabi.trti.config.auth.oauth.provider;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OauthProvider {
    KAKAO("kakao");

    private String content;
}
