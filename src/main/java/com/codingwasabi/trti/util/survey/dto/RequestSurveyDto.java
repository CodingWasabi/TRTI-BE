package com.codingwasabi.trti.util.survey.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class RequestSurveyDto {
    private List<RequestAnswerDto> answers;
}
