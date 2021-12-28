package com.codingwasabi.trti.domain.result.model.values;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Getter
@NoArgsConstructor
@DiscriminatorValue("TOEAT_2")
public class ToEat_2 extends AnswerType {
    @Transient
    private final int ID = 3;

    private ToEat_2(int answer) {
        super(answer);
    }

    public static ToEat_2 from(Integer answer) {
        return new ToEat_2(answer);
    }
}
