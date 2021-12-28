package com.codingwasabi.trti.domain.party;

import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.party.model.request.RequestCreatePartyDto;
import com.codingwasabi.trti.domain.party.model.response.ResponseCreatePartyDto;
import com.codingwasabi.trti.domain.party.model.response.ResponsePartyInfoDto;

public interface PartyService {
    ResponseCreatePartyDto create(Member member, RequestCreatePartyDto requestDto);

    ResponsePartyInfoDto getInfo(Member member, Long id);
}
