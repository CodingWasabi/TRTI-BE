package com.codingwasabi.trti.config.image.s3.uploder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UploadPath {
    GROUP_IMAGE_PATH("image/group");

    private String path;
}
