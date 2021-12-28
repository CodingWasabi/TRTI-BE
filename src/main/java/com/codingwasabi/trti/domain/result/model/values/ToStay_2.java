package com.codingwasabi.trti.domain.result.model.values;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Getter
@NoArgsConstructor
@DiscriminatorValue("TOSTAY_2")
public class ToStay_2 extends AnswerType {
    @Transient
    private final int ID =5;
}
