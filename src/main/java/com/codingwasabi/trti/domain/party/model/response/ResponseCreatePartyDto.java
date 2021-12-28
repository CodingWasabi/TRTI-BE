package com.codingwasabi.trti.domain.party.model.response;

import com.codingwasabi.trti.domain.party.model.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseCreatePartyDto {
    private Long id;

    public static ResponseCreatePartyDto from(Party party) {
        return new ResponseCreatePartyDto(party.getId());
    }
}
