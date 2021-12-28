package com.codingwasabi.trti.domain.party.model.request;

import com.codingwasabi.trti.domain.location.model.Location;
import com.codingwasabi.trti.domain.party.model.Party;
import jdk.javadoc.doclet.Taglet;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class RequestCreatePartyDto {
    private String title;
    private String image;
    private String location;
    private List<Long> members;
    private String[] period;

    public Party getEntityFrom() {
        return Party.builder()
                .title(title)
                .imageLink(image)
                .startDate(LocalDate.parse(period[0]))
                .endDate(LocalDate.parse(period[1]))
                .build();
    }
}
