package com.codingwasabi.trti.domain.member;

import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.member.model.response.ResponseMyInfoDto;

public interface MemberService {
    ResponseMyInfoDto getMemberInfo(Member member);
}
