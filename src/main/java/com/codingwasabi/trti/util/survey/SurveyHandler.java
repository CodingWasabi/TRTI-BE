package com.codingwasabi.trti.util.survey;

import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.result.model.Result;
import com.codingwasabi.trti.util.survey.dto.RequestSurveyDto;

import java.util.List;

public interface SurveyHandler {

    static Result proceed(RequestSurveyDto requestDto) {
        return Result.from(requestDto.getAnswers());
    }

    static Result proceedForParty(List<Member> memberList) {
        Result result = new Result();
        for (Member member : memberList) {
            Result memberResult = member.getResult();
            result.reflect(memberResult);
        }
        return result;
    }
}
