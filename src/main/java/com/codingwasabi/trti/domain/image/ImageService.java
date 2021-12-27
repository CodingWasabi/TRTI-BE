package com.codingwasabi.trti.domain.image;

import com.codingwasabi.trti.domain.image.response.ResponseImageDto;
import com.codingwasabi.trti.domain.member.model.entity.Member;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    ResponseImageDto upload(Member member, MultipartFile image);
}
