package com.codingwasabi.trti.util.annonymous;

import com.codingwasabi.trti.domain.result.model.Result;
import com.codingwasabi.trti.util.annonymous.dto.ResponseAnonymousResultDto;
import com.codingwasabi.trti.util.survey.dto.RequestSurveyDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnonymousService {

    @Transactional
    public ResponseAnonymousResultDto submitSurvey(RequestSurveyDto requestSurveyDto) {
        return ResponseAnonymousResultDto.from(Result.from(requestSurveyDto.getAnswers()));
    }
}
