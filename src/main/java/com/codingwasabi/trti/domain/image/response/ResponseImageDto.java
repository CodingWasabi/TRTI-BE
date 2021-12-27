package com.codingwasabi.trti.domain.image.response;

import com.codingwasabi.trti.domain.image.party.model.PartyImage;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseImageDto {
    private String path;

    public static ResponseImageDto from(PartyImage uploadedImage) {
        return new ResponseImageDto(uploadedImage.getPath());
    }
}
