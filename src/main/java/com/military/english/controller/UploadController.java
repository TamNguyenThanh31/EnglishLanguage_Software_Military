package com.military.english.controller;

import com.military.english.service.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
public class UploadController {

    private final CloudinaryService cloudinaryService;

    /**
     * POST /api/upload?folder=exams
     * Upload một file lên Cloudinary và trả về URL.
     *
     * @param file   file gửi qua multipart/form-data với key = "file"
     * @param folder tên thư mục trên Cloudinary (mặc định: "general")
     */
    @PostMapping
    public ResponseEntity<Map<String, String>> upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "folder", defaultValue = "general") String folder) throws IOException {
        String url = cloudinaryService.upload(file, folder);
        return ResponseEntity.ok(Map.of("url", url));
    }
}
