package com.codingwasabi.trti.domain.image;

import com.codingwasabi.trti.config.auth.security.MemberAdaptor;
import com.codingwasabi.trti.domain.image.response.ResponseImageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageAPI {
    ResponseEntity<?> upload(MemberAdaptor memberAdaptor, MultipartFile image);
}
