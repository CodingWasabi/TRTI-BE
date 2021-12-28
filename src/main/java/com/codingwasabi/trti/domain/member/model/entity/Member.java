package com.codingwasabi.trti.domain.member.model.entity;

import com.codingwasabi.trti.config.auth.oauth.provider.OauthProvider;
import com.codingwasabi.trti.domain.common.Period;
import com.codingwasabi.trti.domain.member.model.enumValue.Authority;
import com.codingwasabi.trti.domain.member.model.enumValue.Gender;
import com.codingwasabi.trti.domain.result.model.Result;
import lombok.*;

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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Result result;

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

    public Result getResult() {
        if (result == null) {
            throw new IllegalArgumentException("[ERROR] " + id + " 사용자는 성향결과가 존재하지 않습니다.");
        }
        return result;
    }

    public void setResult(Result result) {
        if (result == null) {
            throw new IllegalArgumentException("[ERROR] 성향 검사 추출 중 에러가 발생했습니다. (internal error)");
        }
        this.result = result;
    }
}
