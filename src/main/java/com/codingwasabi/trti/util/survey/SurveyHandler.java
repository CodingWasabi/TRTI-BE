package com.codingwasabi.trti.util.survey;

import com.codingwasabi.trti.domain.result.model.Result;
import com.codingwasabi.trti.util.survey.dto.RequestSurveyDto;

public interface SurveyHandler {

    static Result proceed(RequestSurveyDto requestDto) {
        return Result.from(requestDto.getAnswers());
    }
}
