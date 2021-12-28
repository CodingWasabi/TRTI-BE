package com.codingwasabi.trti.domain.result.model.values;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Getter
@NoArgsConstructor
@DiscriminatorValue("TOEAT_1")
public class ToEat_1 extends AnswerType {
    @Transient
    private final int ID = 2;

    private ToEat_1(int answer) {
        super(answer);
    }
    public static ToEat_1 from(Integer answer) {
        return new ToEat_1(answer);
    }
}
