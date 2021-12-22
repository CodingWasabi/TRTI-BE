package com.codingwasabi.trti.config.auth.oauth.kind;

import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.member.model.enumValue.Gender;

public interface OauthInfo {
    String getProviderId();

    String getProviderKind();

    String getEmail();

    String getNickname();

    Gender getGender();

    String getAgeRange();

    String getImagePath();

    Member getEntity();
}
