package com.codingwasabi.trti.domain.result.model.values;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Getter
@NoArgsConstructor
@DiscriminatorValue("TOSTAY_3")
public class ToStay_3 extends AnswerType {
    @Transient
    private final int ID = 6;

    private ToStay_3(int answer) {
        super(answer);
    }
    public static ToStay_3 from(Integer answer) {
        return new ToStay_3(answer);
    }
}
