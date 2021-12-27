package com.codingwasabi.trti.domain.image.group.implementation;

import com.codingwasabi.trti.config.auth.security.MemberAdaptor;
import com.codingwasabi.trti.domain.image.group.GroupImageAPI;
import com.codingwasabi.trti.domain.image.group.GroupImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class GroupImageController implements GroupImageAPI {
    private final GroupImageService groupImageService;

    @Override
    @PostMapping("/image")
    public ResponseEntity<?> upload(@AuthenticationPrincipal MemberAdaptor memberAdaptor,
                                 @RequestParam("image") MultipartFile image) {
        return groupImageService.upload(memberAdaptor.getMember(), image);
    }
}
