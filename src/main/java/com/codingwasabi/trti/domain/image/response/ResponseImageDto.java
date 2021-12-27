package com.codingwasabi.trti.domain.image.response;

import com.codingwasabi.trti.domain.image.group.model.GroupImage;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseImageDto {
    private String path;

    public static ResponseImageDto from(GroupImage uploadedImage) {
        return new ResponseImageDto(uploadedImage.getPath());
    }
}
