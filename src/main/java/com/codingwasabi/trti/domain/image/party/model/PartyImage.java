package com.codingwasabi.trti.domain.image.party.model;

import com.codingwasabi.trti.domain.party.model.Party;
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
public class PartyImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path;

    @OneToOne
    private Party party;

    public static PartyImage of(String path, Party party) {
        return PartyImage.builder()
                .path(path)
                .party(party)
                .build();
    }
}
