package com.codingwasabi.trti.domain.member.impl;

import com.codingwasabi.trti.domain.member.MemberService;
import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.member.model.response.ResponseMyInfoDto;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public ResponseMyInfoDto getMemberInfo(Member member) {
        return ResponseMyInfoDto.getEntity(member);
    }
}
