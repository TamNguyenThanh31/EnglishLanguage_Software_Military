package com.military.english.service;

import com.military.english.model.ExamCreateRequest;
import com.military.english.model.ExamDto;
import org.springframework.lang.NonNull;
import java.util.List;

public interface ExamService {
    ExamDto createExam(ExamCreateRequest request);

    ExamDto getExamById(@NonNull Long id);

    List<ExamDto> getAllExams();
}
