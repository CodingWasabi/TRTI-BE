package com.codingwasabi.trti.domain.result.model.values;

import com.codingwasabi.trti.domain.common.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@DiscriminatorColumn(name = "answer_type")
public abstract class AnswerType extends Period implements CountChanger {
    @Id
    @GeneratedValue
    private Long id;

    private boolean isAgreed = true;

    private int count0 = 0;

    private int count1 = 0;

    private int selected;

    public AnswerType(int selected) {
        this.selected = selected;
    }

    @Override
    public void addCount0() {
        this.count0 ++;
    }

    @Override
    public void addCount1() {
        this.count1++;
    }

    @Override
    public void minusCount0() {
        this.count0--;
    }

    @Override
    public void minusCount1() {
        this.count1--;
    }
}
