package com.codingwasabi.trti.domain.member.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMemberPartyListDto {
    private List<ResponsePartyDto> parties;

    public static ResponseMemberPartyListDto from(List<ResponsePartyDto> allByMember) {
        return new ResponseMemberPartyListDto(allByMember);
    }
}
