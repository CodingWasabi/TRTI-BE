package com.codingwasabi.trti.domain.member;

import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.member.model.request.RequestExistMemberDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseExistMemberDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseMemberPartyListDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseMemberResultDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseMyInfoDto;
import com.codingwasabi.trti.util.survey.dto.RequestSurveyDto;

public interface MemberService {
    ResponseMyInfoDto getMemberInfo(Member member);

    ResponseExistMemberDto existMember(RequestExistMemberDto requestDto);

    ResponseMemberResultDto getResult(Member member);

    void submitSurvey(Member member, RequestSurveyDto requestSurveyDto);

    ResponseMemberPartyListDto getPartyList(Member member);
}
