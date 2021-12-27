package com.codingwasabi.trti.domain.image.party.implementation;

import com.codingwasabi.trti.config.image.s3.uploder.S3ImageUploader;
import com.codingwasabi.trti.config.image.s3.uploder.UploadPath;
import com.codingwasabi.trti.domain.image.party.PartyImageService;
import com.codingwasabi.trti.domain.image.party.model.PartyImage;
import com.codingwasabi.trti.domain.image.party.repository.PartyImageRepository;
import com.codingwasabi.trti.domain.image.response.ResponseImageDto;
import com.codingwasabi.trti.domain.member.model.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PartyImageServiceImpl implements PartyImageService {
    private final UploadPath GROUP_UPLOAD_PATH = UploadPath.GROUP_IMAGE_PATH;

    private final PartyImageRepository groupImageRepository;
    private final S3ImageUploader s3ImageUploader;

    @Override
    public ResponseImageDto upload(Member member, MultipartFile image) {
        String imagePath = s3ImageUploader.uploadFile(GROUP_UPLOAD_PATH, image);

        PartyImage uploadedImage = PartyImage.of(imagePath, null);
        groupImageRepository.save(uploadedImage);

        return ResponseImageDto.from(uploadedImage);
    }
}
