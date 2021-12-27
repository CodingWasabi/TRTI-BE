package com.codingwasabi.trti.domain.member.impl;

import com.codingwasabi.trti.config.auth.security.MemberAdaptor;
import com.codingwasabi.trti.domain.member.MemberService;
import com.codingwasabi.trti.domain.member.model.response.ResponseMyInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/my")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/info")
    public ResponseEntity<ResponseMyInfoDto> getMyInfo(@AuthenticationPrincipal MemberAdaptor memberAdaptor) {
        return ResponseEntity.ok()
                .body(memberService.getMemberInfo(memberAdaptor.getMember()));
    }
}
