package com.codingwasabi.trti.domain.member.model.response;

import com.codingwasabi.trti.domain.result.model.values.AnswerType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseMemberDetailResultDto {
    private int id;
    private Integer selected;

    public static ResponseMemberDetailResultDto from(AnswerType answerType) {
        return new ResponseMemberDetailResultDto(answerType.getTypeId(), answerType.getSelected());
    }
}
