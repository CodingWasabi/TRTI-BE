package com.codingwasabi.trti.domain.group.model;

import com.codingwasabi.trti.domain.common.Period;
import com.codingwasabi.trti.domain.location.model.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Group extends Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String imageLink;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean isAgreed;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;
}
