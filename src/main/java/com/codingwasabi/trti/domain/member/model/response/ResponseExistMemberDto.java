package com.codingwasabi.trti.domain.member.model.response;

import com.codingwasabi.trti.domain.member.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseExistMemberDto {
    private String nickname;
    private Long id;

    public static ResponseExistMemberDto from(Member member) {
        return new ResponseExistMemberDto(member.getNickname(), member.getId());
    }
}
