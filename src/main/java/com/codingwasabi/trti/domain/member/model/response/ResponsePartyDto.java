package com.codingwasabi.trti.domain.member.model.response;

import com.codingwasabi.trti.domain.party.model.Party;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResponsePartyDto {
    private Long id;
    private String title;
    private String location;
    private int participantsCount;
    private String imageUrl;
    private boolean isAgreed;
    private String[] period;

    public static ResponsePartyDto of(Party party, int participantsCount) {
        return ResponsePartyDto.builder()
                .id(party.getId())
                .title(party.getTitle())
                .location(party.getCity().getLocation().getName())
                .imageUrl(party.getImageLink())
                .isAgreed(party.isAgreed())
                .period(party.getPeriod())
                .participantsCount(participantsCount)
                .build();
    }
}
