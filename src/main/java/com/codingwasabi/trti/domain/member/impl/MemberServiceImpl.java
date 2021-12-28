package com.codingwasabi.trti.domain.member.impl;

import com.codingwasabi.trti.domain.member.MemberService;
import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.member.model.request.RequestExistMemberDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseExistMemberDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseMyInfoDto;
import com.codingwasabi.trti.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public ResponseMyInfoDto getMemberInfo(Member member) {
        return ResponseMyInfoDto.getEntity(member);
    }

    @Override
    public ResponseExistMemberDto existMember(RequestExistMemberDto requestDto) {
        // Error Code 생성
        Member member = memberRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력된 이메일의 회원은 존재하지 않습니다."));

        return ResponseExistMemberDto.from(member);
    }
}
