package com.codingwasabi.trti.domain.party.model.response;

import com.codingwasabi.trti.domain.memberInParty.model.MemberInParty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResponseMemberDto {
    private String nickname;
    private String imageUrl;

    public static ResponseMemberDto from(MemberInParty memberInParty) {
        return ResponseMemberDto.builder()
                .nickname(memberInParty.getMember().getNickname())
                .imageUrl(memberInParty.getMember().getImagePath())
                .build();
    }
}
