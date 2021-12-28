package com.codingwasabi.trti.domain.party.implementation;

import com.codingwasabi.trti.config.auth.security.MemberAdaptor;
import com.codingwasabi.trti.domain.party.PartyAPI;
import com.codingwasabi.trti.domain.party.PartyService;
import com.codingwasabi.trti.domain.party.model.request.RequestCreatePartyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/party")
public class PartyController implements PartyAPI {
    private final PartyService partyService;

    @Override
    @PostMapping
    public ResponseEntity<?> createParty(@AuthenticationPrincipal MemberAdaptor memberAdaptor,
                                         @RequestBody RequestCreatePartyDto requestDto) {
        return ResponseEntity.ok(partyService.create(memberAdaptor.getMember(), requestDto));
    }

    @Override
    @GetMapping("/info")
    public ResponseEntity<?> getPartyInfo(@AuthenticationPrincipal MemberAdaptor memberAdaptor,
                                          @RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(partyService.getInfo(memberAdaptor.getMember(), id));
    }

    @Override
    @GetMapping("/members")
    public ResponseEntity<?> getPartyMemberList(@AuthenticationPrincipal MemberAdaptor memberAdaptor,
                                                @RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(partyService.getMemberList(memberAdaptor.getMember(), id));
    }

    @Override
    public ResponseEntity<?> getPartyResult(MemberAdaptor memberAdaptor, Long id) {
        return ResponseEntity.ok(partyService.getResult(memberAdaptor.getMember(), id));
    }
}
