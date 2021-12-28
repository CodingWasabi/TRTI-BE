package com.codingwasabi.trti.domain.party.model.response;

import com.codingwasabi.trti.domain.party.model.Party;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
public class ResponsePartyInfoDto {
    private Long id;
    private String title;
    private String location;
    @Setter
    private Integer participantsCount;
    private String imageUrl;
    private Boolean isAgreed;
    private String[] period;

    public static ResponsePartyInfoDto from(Party party) {
        return ResponsePartyInfoDto.builder()
                .id(party.getId())
                .title(party.getTitle())
                .location(party.getCity().getLocation().getName())
                .imageUrl(party.getImageLink())
                .isAgreed(party.isAgreed())
                .period(party.getPeriod())
                .build();
    }
}
