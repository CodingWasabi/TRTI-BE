package com.codingwasabi.trti.util.survey.dto;

import lombok.Getter;

@Getter
public class RequestAnswerDto {
    private Long id;
    private Integer answer;

    public boolean is(long id) {
        return this.id == id;
    }
}
