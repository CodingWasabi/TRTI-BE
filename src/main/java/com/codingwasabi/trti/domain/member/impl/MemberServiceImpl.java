package com.codingwasabi.trti.domain.member.impl;

import com.codingwasabi.trti.domain.member.MemberService;
import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.member.model.request.RequestExistMemberDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseExistMemberDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseMemberResultDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseMyInfoDto;
import com.codingwasabi.trti.domain.member.repository.MemberRepository;
import com.codingwasabi.trti.domain.result.model.Result;
import com.codingwasabi.trti.domain.result.repository.ResultRepository;
import com.codingwasabi.trti.util.survey.SurveyHandler;
import com.codingwasabi.trti.util.survey.dto.RequestSurveyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final ResultRepository resultRepository;

    @Override
    @Transactional(readOnly = true)
    public ResponseMyInfoDto getMemberInfo(Member member) {
        return ResponseMyInfoDto.getEntity(member);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseExistMemberDto existMember(RequestExistMemberDto requestDto) {
        // Error Code 생성
        Member member = memberRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력된 이메일의 회원은 존재하지 않습니다."));

        return ResponseExistMemberDto.from(member);
    }

    @Override
    public ResponseMemberResultDto getResult(Member member) {
        return ResponseMemberResultDto.from(member);
    }

    @Override
    public void submitSurvey(Member member, RequestSurveyDto requestSurveyDto) {
        Result result = SurveyHandler.proceed(requestSurveyDto);
        resultRepository.save(result);
        
        member.setResult(result);
        memberRepository.save(member);
    }
}
