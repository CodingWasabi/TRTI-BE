package com.codingwasabi.trti.domain.member.model.response;

import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.member.model.enumValue.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResponseMyInfoDto {
    private Long id;
    private String nickname;
    private String email;
    private String imageUrl;
    private String ageRange;
    private Gender gender;

    public static ResponseMyInfoDto getEntity(Member member) {
        return ResponseMyInfoDto.builder()
                .id(member.getId())
                .nickname(member.getNickname())
                .email(member.getEmail())
                .imageUrl(member.getImagePath())
                .ageRange(member.getAgeRange())
                .gender(member.getGender())
                .build();
    }
}
