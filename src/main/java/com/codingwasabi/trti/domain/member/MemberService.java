package com.codingwasabi.trti.domain.member;

import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.member.model.request.RequestExistMemberDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseExistMemberDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseMemberResultDto;
import com.codingwasabi.trti.domain.member.model.response.ResponseMyInfoDto;

public interface MemberService {
    ResponseMyInfoDto getMemberInfo(Member member);

    ResponseExistMemberDto existMember(RequestExistMemberDto requestDto);

    ResponseMemberResultDto getResult(Member member);
}
