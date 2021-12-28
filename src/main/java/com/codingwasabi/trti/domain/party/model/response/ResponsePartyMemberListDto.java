package com.codingwasabi.trti.domain.party.model.response;

import com.codingwasabi.trti.domain.memberInParty.model.MemberInParty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResponsePartyMemberListDto {
    private Integer membersCount;
    private List<ResponseMemberDto> members;

    public static ResponsePartyMemberListDto of(int membersCount, List<ResponseMemberDto> members) {
        return new ResponsePartyMemberListDto(membersCount, members);
    }
}
