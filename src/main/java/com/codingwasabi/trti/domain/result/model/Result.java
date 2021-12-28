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
    private ToMove toMove = new ToMove();

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ToEat_1 toEat_1 = new ToEat_1();

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ToEat_2 toEat_2 = new ToEat_2();

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ToStay_1 toStay_1 = new ToStay_1();

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ToStay_2 toStay_2 = new ToStay_2();

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ToStay_3 toStay_3 = new ToStay_3();

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ToActive toActive = new ToActive();

    public static Result from(List<RequestAnswerDto> answers) {
        ToMove toMove = null;
        ToEat_1 toEat_1 = null;
        ToEat_2 toEat_2 = null;
        ToStay_1 toStay_1 = null;
        ToStay_2 toStay_2 = null;
        ToStay_3 toStay_3 = null;
        ToActive toActive = null;

        for (RequestAnswerDto answer : answers) {
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

    public void reflect(Result memberResult) {
        reflectToMove(memberResult.getToMove());
        reflectToEat_1(memberResult.getToEat_1());
        reflectToEat_2(memberResult.getToEat_2());
        reflectToStay_1(memberResult.getToStay_1());
        reflectToStay_2(memberResult.getToStay_2());
        reflectToStay_3(memberResult.getToStay_3());
        reflectToActive(memberResult.getToActive());
    }

    public boolean isConflict() {
        if (toMove.isConflict() ||
                toEat_1.isConflict() ||
                toEat_2.isConflict() ||
                toStay_1.isConflict() ||
                toStay_2.isConflict() ||
                toStay_3.isConflict() ||
                toActive.isConflict()) {
            return true;
        }

        return false;
    }

    private void reflectToMove(ToMove toMove) {
        if (isZero(toMove)) {
            this.toMove.addCount0();
        } else {
            this.toMove.addCount1();
        }
    }

    private void reflectToEat_1(ToEat_1 toEat_1) {
        if (isZero(toEat_1)) {
            this.toEat_1.addCount0();
        } else {
            this.toEat_1.addCount1();
        }
    }

    private void reflectToEat_2(ToEat_2 toEat_2) {
        if (isZero(toEat_2)) {
            this.toEat_2.addCount0();
        } else {
            this.toEat_2.addCount1();
        }
    }

    private void reflectToStay_1(ToStay_1 toStay_1) {
        if (isZero(toStay_1)) {
            this.toStay_1.addCount0();
        } else {
            this.toStay_1.addCount1();
        }
    }

    private void reflectToStay_2(ToStay_2 toStay_2) {
        if (isZero(toStay_2)) {
            this.toStay_2.addCount0();
        } else {
            this.toStay_2.addCount1();
        }
    }

    private void reflectToStay_3(ToStay_3 toStay_3) {
        if (isZero(toStay_3)) {
            this.toStay_3.addCount0();
        }
        else {
            this.toStay_3.addCount1();
        }
    }

    private void reflectToActive(ToActive toActive) {
        if (isZero(toActive)) {
            this.toActive.addCount0();
        }
        else {
            this.toActive.addCount1();
        }
    }

    private boolean isZero(AnswerType answerType) {
        return answerType.getSelected() == 0;
    }
}
