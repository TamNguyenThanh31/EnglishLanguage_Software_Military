package com.military.english.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryService {

    private final Cloudinary cloudinary;

    /**
     * Upload file lên Cloudinary và trả về URL công khai.
     *
     * @param file   file ảnh / âm thanh / video từ client gửi lên
     * @param folder thư mục lưu trên Cloudinary (ví dụ: "exams", "avatars")
     * @return URL công khai của file đã upload
     */
    public String upload(MultipartFile file, String folder) throws IOException {
        Map<?, ?> result = cloudinary.uploader().upload(
                file.getBytes(),
                ObjectUtils.asMap(
                        "folder", folder,
                        "resource_type", "auto" // Tự phát hiện: image / video / raw
                ));
        return (String) result.get("secure_url");
    }

    /**
     * Xóa file trên Cloudinary theo public_id.
     *
     * @param publicId public_id của file (lấy từ kết quả upload)
     */
    public void delete(String publicId) throws IOException {
        cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
    }
}
