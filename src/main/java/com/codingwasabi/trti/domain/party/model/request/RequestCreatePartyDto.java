package com.codingwasabi.trti.domain.party.model.request;

import com.codingwasabi.trti.domain.party.model.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class RequestCreatePartyDto {
    private String title;
    private String imageUrl;
    private String location;
    private List<Long> members;
    private String[] period;

    public Party getEntityFrom() {
        return Party.builder()
                .title(title)
                .imageLink(imageUrl)
                .startDate(period[0])
                .endDate(period[1])
                .build();
    }
}
