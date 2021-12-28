package com.codingwasabi.trti.domain.party.model.response;

import com.codingwasabi.trti.domain.result.model.values.AnswerType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponsePartyDetailResultDto {
    private int id;
    private boolean isAgreed;
    private int count0;
    private int count1;
    private int selected;

    public static ResponsePartyDetailResultDto from(AnswerType answerType) {
        return new ResponsePartyDetailResultDto(answerType.getTypeId(),
                answerType.isAgreed(),
                answerType.getCount0(),
                answerType.getCount1(),
                answerType.getSelected());
    }
}
