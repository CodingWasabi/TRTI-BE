package com.codingwasabi.trti.domain.party;

import com.codingwasabi.trti.config.auth.security.MemberAdaptor;
import com.codingwasabi.trti.domain.party.model.request.RequestCreatePartyDto;
import org.springframework.http.ResponseEntity;

public interface PartyAPI {
    ResponseEntity<?> createParty(MemberAdaptor memberAdaptor, RequestCreatePartyDto requestDto);
}
