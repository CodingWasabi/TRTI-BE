package com.codingwasabi.trti.domain.party.model;

import com.codingwasabi.trti.domain.common.Period;
import com.codingwasabi.trti.domain.city.model.City;
import com.codingwasabi.trti.domain.member.model.entity.Member;
import com.codingwasabi.trti.domain.result.model.Result;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Party extends Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String imageLink;

    private String startDate;

    private String endDate;

    private boolean isAgreed = true;

    @OneToOne
    private Result result;

    @OneToOne(fetch = FetchType.LAZY)
    private Member captain;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    public void setCaptain(Member member) {
        // Error code
        if (member == null) {
            throw new IllegalArgumentException("[EROOR] 잘못된 접근입니다. (사용자가 유효하지 않음)");
        }

        this.captain = member;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String[] getPeriod() {
        return new String[] {startDate, endDate};
    }

    public void setResult(Result result) {
        if (result == null) {
            throw new IllegalArgumentException("[ERROR] 그룹의 결과처리 과정에서 에러가 발생했습니다. (internal error)");
        }

        if(result.isConflict()) {
            isAgreed = false;
        }
        else {
            isAgreed = true;
        }

        this.result = result;
    }
}
