package com.codingwasabi.trti.util.survey.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TRTIKind {
    TOMOVE(1L),
    TOEAT_1(2L),
    TOEAT_2(3L),
    TOSTAY_1(4L),
    TOSTAY_2(5L),
    TOSTAY_3(6L),
    TOACTIVE(7L);

    private Long kind;
}
