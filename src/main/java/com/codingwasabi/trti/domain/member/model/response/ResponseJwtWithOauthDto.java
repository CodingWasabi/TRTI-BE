package com.codingwasabi.trti.domain.member.model.response;

import lombok.Getter;

@Getter
public class ResponseJwtWithOauthDto {
    private String type;
    private String token;

    private ResponseJwtWithOauthDto(String type, String token) {
        this.type = type;
        this.token = token;
    }
    public static ResponseJwtWithOauthDto of(String type, String token) {
        return new ResponseJwtWithOauthDto(type, token);
    }
}
