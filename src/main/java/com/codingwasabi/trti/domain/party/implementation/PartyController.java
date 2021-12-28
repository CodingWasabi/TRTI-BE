package com.codingwasabi.trti.domain.party.implementation;

import com.codingwasabi.trti.config.auth.security.MemberAdaptor;
import com.codingwasabi.trti.domain.party.PartyAPI;
import com.codingwasabi.trti.domain.party.PartyService;
import com.codingwasabi.trti.domain.party.model.request.RequestCreatePartyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class PartyController implements PartyAPI {
    private final PartyService partyService;

    @Override
    @PostMapping
    public ResponseEntity<?> createParty(@AuthenticationPrincipal MemberAdaptor memberAdaptor,
                                         @RequestBody RequestCreatePartyDto requestDto) {
        return ResponseEntity.ok(partyService.create(memberAdaptor.getMember(), requestDto));
    }
}
