package com.codingwasabi.trti.domain.member.model.entity;

import com.codingwasabi.trti.config.auth.oauth.provider.OauthProvider;
import com.codingwasabi.trti.domain.common.Period;
import com.codingwasabi.trti.domain.member.model.enumValue.Authority;
import com.codingwasabi.trti.domain.member.model.enumValue.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String oauthId;

    private String email;

    private String ageRange;

    private String imagePath;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private OauthProvider provider;

    @Column
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Authority authority = Authority.USER;

    public Authority getAuthority() {
        return authority;
    }
}
