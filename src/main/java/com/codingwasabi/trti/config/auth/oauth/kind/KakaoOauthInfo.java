package com.codingwasabi.trti.config.auth.oauth.kind;

import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.member.model.enumValue.Gender;

import java.util.Map;

import static com.codingwasabi.trti.config.auth.oauth.provider.OauthProvider.KAKAO;

public class KakaoOauthInfo implements OauthInfo{
    private final Map<String, Object> attributeMap;

    private KakaoOauthInfo(Map<String, Object> attributeMap) {
        this.attributeMap = attributeMap;
    }

    public static KakaoOauthInfo from(Map<String, Object> attributeMap) {
        return new KakaoOauthInfo(attributeMap);
    }

    @Override
    public Gender getGender() {
        return Gender.valueOf((String) attributeMap.get("gender"));
    }

    @Override
    public String getAgeRange() {
        return (String) attributeMap.get("ageRange");
    }

    @Override
    public String getImagePath() {
        return (String) attributeMap.get("profileImage");
    }

    @Override
    public String getProviderId() {
        return "k_" + attributeMap.get("kakaoId");
    }

    @Override
    public String getProviderKind() {
        return KAKAO.toString();
    }

    @Override
    public String getEmail() {
        return (String) attributeMap.get("email");
    }

    @Override
    public String getNickname() {
        return (String) attributeMap.get("nickname");
    }

    @Override
    public Member getEntity() {
        return Member.builder()
                .oauthId(getProviderId())
                .email(getEmail())
                .ageRange(getAgeRange())
                .gender(getGender())
                .imagePath(getImagePath())
                .nickname(getNickname())
                .provider(KAKAO)
                .build();
    }
}
