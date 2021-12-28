package com.codingwasabi.trti.domain.party.model;

import com.codingwasabi.trti.domain.common.Period;
import com.codingwasabi.trti.domain.location.model.Location;
import com.codingwasabi.trti.domain.member.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;

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

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean isAgreed;

    @OneToOne(fetch = FetchType.LAZY)
    private Member captain;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

    public void setCaptain(Member member) {
        // Error code
        if (member == null) {
            throw new IllegalArgumentException("[EROOR] 잘못된 접근입니다. (사용자가 유효하지 않음)");
        }

        this.captain = member;
    }

    public void setLocation(Location city) {
        this.location = city;
    }
}
