package com.codingwasabi.trti.domain.result.model.values;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Getter
@NoArgsConstructor
@DiscriminatorValue("TOACTIVE")
public class ToActive extends AnswerType {
    @Transient
    private final int ID = 7;

    private ToActive(int answer) {
        super(answer);
    }
    public static ToActive from(Integer answer) {
        return new ToActive(answer);
    }

    @Override
    public int getTypeId() {
        return ID;
    }
}
