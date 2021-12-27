package com.codingwasabi.trti.config.image.s3.uploder;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class S3ImageUploader {
    private final S3Client s3Client;

    @Value("${cloud.aws.s3.bucket}")
    public String bucket;

    @Value("${cloud.aws.s3.bucket-url}")
    public String bucketUrl;

    public String uploadFile(UploadPath path, MultipartFile file) throws SdkException {
        String imagePath =  generatePathKey(path.getPath());

        // error code 추가
        Optional.ofNullable(file).orElseThrow(() -> new IllegalArgumentException("[ERROR] 이미지가 null 입니다."));

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucket)
                .key(imagePath)
                .contentType(file.getContentType())
                .build();

        try {
                s3Client.putObject(request, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
        } catch (IOException e) {
            // ERROR code 추가
            throw new IllegalArgumentException("[ERROR] 이미지 업로드에 문제가 발생했습니다.");
        }

        return getPathUrl(imagePath);
    }

    private String getPathUrl(String imagePath) {
        return bucketUrl + imagePath;
    }

    private String generatePathKey(String filePath) {
        return filePath + UUID.randomUUID();
    }
}
