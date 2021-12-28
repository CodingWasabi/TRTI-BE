package com.codingwasabi.trti.domain.result.model.values;

import com.codingwasabi.trti.domain.common.Period;
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

    private Boolean isAgreed = true;

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

    public boolean isConflict() {
        if (count0 == count1) {
            isAgreed = false;
            selected = 2;
            return true;
        }

        if(count0 > count1) {
            selected = 0;
        }

        else {
            selected = 1;
        }

        return false;
    }

    public abstract int getTypeId();
}
