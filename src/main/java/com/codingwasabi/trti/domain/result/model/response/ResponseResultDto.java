package com.codingwasabi.trti.domain.result.model.response;

import com.codingwasabi.trti.domain.member.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResponseResultDto {
    private String name;
    private ResponseResultDetailDto result;

    public static ResponseResultDto from(Member member) {
        return ResponseResultDto.builder()
                .name(member.getNickname())
                .result(ResponseResultDetailDto.from(member.getResult()))
                .build();
    }
}
