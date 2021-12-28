package com.codingwasabi.trti.domain.party.model.response;

import com.codingwasabi.trti.domain.result.model.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePartyResultDto {
    private List<ResponsePartyDetailResultDto> answers;

    public static ResponsePartyResultDto from(Result result) {
        return new ResponsePartyResultDto(getDetailResult(result));
    }

    private static List<ResponsePartyDetailResultDto> getDetailResult(Result result) {
        List<ResponsePartyDetailResultDto> resultList = new ArrayList<>();
        resultList.add(ResponsePartyDetailResultDto.from(result.getToMove()));
        resultList.add(ResponsePartyDetailResultDto.from(result.getToEat_1()));
        resultList.add(ResponsePartyDetailResultDto.from(result.getToEat_2()));
        resultList.add(ResponsePartyDetailResultDto.from(result.getToStay_1()));
        resultList.add(ResponsePartyDetailResultDto.from(result.getToStay_2()));
        resultList.add(ResponsePartyDetailResultDto.from(result.getToStay_3()));
        resultList.add(ResponsePartyDetailResultDto.from(result.getToActive()));

        return resultList;
    }
}
