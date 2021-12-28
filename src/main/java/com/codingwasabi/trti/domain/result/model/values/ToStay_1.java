package com.codingwasabi.trti.domain.result.model.values;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Getter
@NoArgsConstructor
@DiscriminatorValue("TOSTAY_!")
public class ToStay_1 extends AnswerType {
    @Transient
    private final int ID = 4;

    private ToStay_1(int answer) {
        super(answer);
    }
    public static ToStay_1 from(Integer answer) {
        return new ToStay_1(answer);
    }

    @Override
    public int getTypeId() {
        return ID;
    }
}
