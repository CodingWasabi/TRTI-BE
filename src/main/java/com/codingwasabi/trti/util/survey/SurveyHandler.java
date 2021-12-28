package com.codingwasabi.trti.util.survey;

import com.codingwasabi.trti.domain.result.model.Result;
import com.codingwasabi.trti.util.survey.dto.RequestSurveyDto;

public interface SurveyHandler {
    Result proceed(RequestSurveyDto requestDto);
}
