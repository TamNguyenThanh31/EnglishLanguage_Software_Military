package com.military.english.model;

import com.military.english.enums.Level;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ExamDto {
    private Long id;
    private String title;
    private Level level;
    private Integer timeLimitMinutes;
    private Long teacherId;
    private LocalDateTime createdAt;
    private List<QuestionDto> questions; // Chứa luôn danh sách câu hỏi khi trả về
}
