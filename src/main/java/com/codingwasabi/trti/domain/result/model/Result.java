package com.codingwasabi.trti.domain.result.model;

import com.codingwasabi.trti.domain.result.model.values.*;
import com.codingwasabi.trti.util.survey.dto.RequestAnswerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ToMove toMove;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ToEat_1 toEat_1;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ToEat_2 toEat_2;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ToStay_1 toStay_1;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ToStay_2 toStay_2;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ToStay_3 toStay_3;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ToActive toActive;

    public static Result from(List<RequestAnswerDto> answers) {
        ToMove toMove = null;
        ToEat_1 toEat_1 = null;
        ToEat_2 toEat_2 = null;
        ToStay_1 toStay_1 = null;
        ToStay_2 toStay_2 = null;
        ToStay_3 toStay_3 = null;
        ToActive toActive = null;

        for(RequestAnswerDto answer : answers) {
            if (answer.is(1L)) {
                toMove = ToMove.from(answer.getAnswer());
                continue;
            }
            if (answer.is(2L)) {
                toEat_1 = ToEat_1.from(answer.getAnswer());
                continue;
            }
            if (answer.is(3L)) {
                toEat_2 = ToEat_2.from(answer.getAnswer());
                continue;
            }
            if (answer.is(4L)) {
                toStay_1 = ToStay_1.from(answer.getAnswer());
                continue;
            }
            if (answer.is(5L)) {
                toStay_2 = ToStay_2.from(answer.getAnswer());
                continue;
            }
            if (answer.is(6L)) {
                toStay_3 = ToStay_3.from(answer.getAnswer());
                continue;
            }
            if (answer.is(7L)) {
                toActive = ToActive.from(answer.getAnswer());
            }
        }

        return Result.builder()
                .toMove(toMove)
                .toEat_1(toEat_1)
                .toEat_2(toEat_2)
                .toStay_1(toStay_1)
                .toStay_2(toStay_2)
                .toStay_3(toStay_3)
                .toActive(toActive)
                .build();
    }
}
