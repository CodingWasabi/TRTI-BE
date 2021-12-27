package com.codingwasabi.trti.domain.image.group.implementation;

import com.codingwasabi.trti.config.image.s3.uploder.S3ImageUploader;
import com.codingwasabi.trti.config.image.s3.uploder.UploadPath;
import com.codingwasabi.trti.domain.image.group.GroupImageService;
import com.codingwasabi.trti.domain.image.group.model.GroupImage;
import com.codingwasabi.trti.domain.image.group.repository.GroupImageRepository;
import com.codingwasabi.trti.domain.image.response.ResponseImageDto;
import com.codingwasabi.trti.domain.member.model.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class GroupImageServiceImpl implements GroupImageService {
    private final UploadPath GROUP_UPLOAD_PATH = UploadPath.GROUP_IMAGE_PATH;

    private final GroupImageRepository groupImageRepository;
    private final S3ImageUploader s3ImageUploader;

    @Override
    public ResponseImageDto upload(Member member, MultipartFile image) {
        String imagePath = s3ImageUploader.uploadFile(GROUP_UPLOAD_PATH, image);

        GroupImage uploadedImage = GroupImage.of(imagePath, group);
        groupImageRepository.save(uploadedImage);

        return ResponseImageDto.from(uploadedImage);
    }
}
