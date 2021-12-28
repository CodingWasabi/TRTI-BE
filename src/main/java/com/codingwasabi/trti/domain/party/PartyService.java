package com.codingwasabi.trti.domain.party;

import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.party.model.request.RequestCreatePartyDto;
import com.codingwasabi.trti.domain.party.model.response.ResponseCreatePartyDto;
import com.codingwasabi.trti.domain.party.model.response.ResponsePartyInfoDto;
import com.codingwasabi.trti.domain.party.model.response.ResponsePartyMemberListDto;
import com.codingwasabi.trti.domain.party.model.response.ResponsePartyResultDto;

public interface PartyService {
    ResponseCreatePartyDto create(Member member, RequestCreatePartyDto requestDto);

    ResponsePartyInfoDto getInfo(Member member, Long id);

    ResponsePartyMemberListDto getMemberList(Member member, Long id);

    ResponsePartyResultDto getResult(Member member, Long id);
}
