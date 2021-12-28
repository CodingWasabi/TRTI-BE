package com.codingwasabi.trti.util.annonymous.dto;

import com.codingwasabi.trti.domain.member.model.response.ResponseMemberDetailResultDto;
import com.codingwasabi.trti.domain.result.model.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class ResponseAnonymousResultDto {
    private List<ResponseMemberDetailResultDto> answers;

    public static ResponseAnonymousResultDto from(Result result) {
        return new ResponseAnonymousResultDto(getDetailResult(result));
    }

    private static List<ResponseMemberDetailResultDto> getDetailResult(Result result) {
        List<ResponseMemberDetailResultDto> resultList = new ArrayList<>();
        resultList.add(ResponseMemberDetailResultDto.from(result.getToMove()));
        resultList.add(ResponseMemberDetailResultDto.from(result.getToEat_1()));
        resultList.add(ResponseMemberDetailResultDto.from(result.getToEat_2()));
        resultList.add(ResponseMemberDetailResultDto.from(result.getToStay_1()));
        resultList.add(ResponseMemberDetailResultDto.from(result.getToStay_2()));
        resultList.add(ResponseMemberDetailResultDto.from(result.getToStay_3()));
        resultList.add(ResponseMemberDetailResultDto.from(result.getToActive()));

        return resultList;
    }
}
