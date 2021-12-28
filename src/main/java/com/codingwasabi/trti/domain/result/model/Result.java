package com.codingwasabi.trti.domain.result.model;

import com.codingwasabi.trti.domain.result.model.values.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ToStay toStay;

    @Enumerated(EnumType.STRING)
    private ToEat toEat;

    @Enumerated(EnumType.STRING)
    private ToMove toMove;

    @Enumerated(EnumType.STRING)
    private ToActive toActive;

    @Enumerated(EnumType.STRING)
    private Time time;

}
