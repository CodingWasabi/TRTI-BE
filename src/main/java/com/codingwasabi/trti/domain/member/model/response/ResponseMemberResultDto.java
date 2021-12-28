package com.codingwasabi.trti.domain.member.model.response;

import com.codingwasabi.trti.domain.member.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class ResponseMemberResultDto {
    private String name;
    private List<ResponseMemberDetailResultDto> answers;

    public static ResponseMemberResultDto from(Member member) {
        return new ResponseMemberResultDto(member.getNickname(), getDetailResult(member));
    }

    private static List<ResponseMemberDetailResultDto> getDetailResult(Member member) {
        List<ResponseMemberDetailResultDto> resultList = new ArrayList<>();
        resultList.add(ResponseMemberDetailResultDto.from(member.getResult().getToMove()));
        resultList.add(ResponseMemberDetailResultDto.from(member.getResult().getToEat_1()));
        resultList.add(ResponseMemberDetailResultDto.from(member.getResult().getToEat_2()));
        resultList.add(ResponseMemberDetailResultDto.from(member.getResult().getToStay_1()));
        resultList.add(ResponseMemberDetailResultDto.from(member.getResult().getToStay_2()));
        resultList.add(ResponseMemberDetailResultDto.from(member.getResult().getToStay_3()));
        resultList.add(ResponseMemberDetailResultDto.from(member.getResult().getToActive()));

        return resultList;
    }
}
