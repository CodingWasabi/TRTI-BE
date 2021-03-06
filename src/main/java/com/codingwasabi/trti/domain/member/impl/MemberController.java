package com.codingwasabi.trti.domain.member.impl;

import com.codingwasabi.trti.config.auth.security.MemberAdaptor;
import com.codingwasabi.trti.domain.member.MemberService;
import com.codingwasabi.trti.domain.member.model.request.RequestExistMemberDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseExistMemberDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseMemberPartyListDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseMemberResultDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseMyInfoDto;
import com.codingwasabi.trti.util.survey.dto.RequestSurveyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/my/info")
    public ResponseEntity<ResponseMyInfoDto> getMyInfo(@AuthenticationPrincipal MemberAdaptor memberAdaptor) {
        return ResponseEntity.ok()
                .body(memberService.getMemberInfo(memberAdaptor.getMember()));
    }

    @PostMapping("/member")
    public ResponseEntity<ResponseExistMemberDto> existMember(@RequestBody RequestExistMemberDto requestDto) {
        return ResponseEntity.ok(memberService.existMember(requestDto));
    }

    @GetMapping("/my/result")
    public ResponseEntity<ResponseMemberResultDto>
    getMemberResult(@AuthenticationPrincipal MemberAdaptor memberAdaptor) {
        return ResponseEntity.ok(memberService.getResult(memberAdaptor.getMember()));
    }

    @PostMapping("/survey")
    public ResponseEntity<?> submitSurvey(@AuthenticationPrincipal MemberAdaptor memberAdaptor,
                                          @RequestBody RequestSurveyDto requestSurveyDto) {
        memberService.submitSurvey(memberAdaptor.getMember(), requestSurveyDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/my/party")
    public ResponseEntity<ResponseMemberPartyListDto>
    getPartyList(@AuthenticationPrincipal MemberAdaptor memberAdaptor) {
        return ResponseEntity.ok(memberService.getPartyList(memberAdaptor.getMember()));
    }
}
