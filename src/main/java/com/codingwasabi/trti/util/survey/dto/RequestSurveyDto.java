package com.codingwasabi.trti.util.survey.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestSurveyDto {
    private List<RequestAnswerDto> answers;
}
