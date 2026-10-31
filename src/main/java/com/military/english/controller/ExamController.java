package com.military.english.controller;

import com.military.english.model.ExamCreateRequest;
import com.military.english.model.ExamDto;
import com.military.english.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/exams")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    // tao de thi + cau hoi
    @PostMapping
    public ResponseEntity<ExamDto> createExam(@RequestBody ExamCreateRequest request) {
        return ResponseEntity.ok(examService.createExam(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamDto> getExamById(@PathVariable @org.springframework.lang.NonNull Long id) {
        return ResponseEntity.ok(examService.getExamById(id));
    }

    @GetMapping
    public ResponseEntity<List<ExamDto>> getAllExams() {
        return ResponseEntity.ok(examService.getAllExams());
    }
}
