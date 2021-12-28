package com.codingwasabi.trti.domain.member;

import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.member.model.request.RequestExistMemberDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseExistMemberDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseMyInfoDto;
import com.codingwasabi.trti.domain.result.model.response.ResponseResultDto;

public interface MemberService {
    ResponseMyInfoDto getMemberInfo(Member member);

    ResponseExistMemberDto existMember(RequestExistMemberDto requestDto);

    ResponseResultDto getResult(Member member);
}
