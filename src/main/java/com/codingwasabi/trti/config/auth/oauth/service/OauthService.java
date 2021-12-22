package com.codingwasabi.trti.config.auth.oauth.service;

import com.codingwasabi.trti.config.auth.oauth.kind.KakaoOauthInfo;
import com.codingwasabi.trti.config.auth.oauth.kind.OauthInfo;
import com.codingwasabi.trti.config.auth.oauth.provider.OauthProvider;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OauthService {
    public OauthInfo filtrateOauth(String provider, Map<String, Object> requestMap) {
        if(isKakao(provider)) {
            return getKakao(requestMap);
        }

        // error code 추가
        // "올바르지 못한 oauth 접근"
        throw new IllegalArgumentException("Error");
    }

    private OauthInfo getKakao(Map<String, Object> requestMap) {
        return KakaoOauthInfo.from(requestMap);
    }

    private boolean isKakao(String provider) {
        return provider.equals(OauthProvider.KAKAO);
    }
}
