package com.codingwasabi.trti.domain.result.model.response;

import com.codingwasabi.trti.domain.result.model.Result;
import com.codingwasabi.trti.domain.result.model.values.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResponseResultDetailDto {
    private ToStay toStay;
    private ToEat toEat;
    private ToMove toMove;
    private ToActive toActive;
    private Time time;

    public static ResponseResultDetailDto from(Result result) {
        return ResponseResultDetailDto.builder()
                .toStay(result.getToStay())
                .toEat(result.getToEat())
                .toMove(result.getToMove())
                .toActive(result.getToActive())
                .time(result.getTime())
                .build();
    }
}
