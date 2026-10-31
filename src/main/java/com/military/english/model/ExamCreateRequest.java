package com.military.english.model;

import com.military.english.enums.Level;
import lombok.Data;
import java.util.List;

@Data
public class ExamCreateRequest {
    private String title;
    private Level level;
    private Integer timeLimitMinutes;
    private Long teacherId; // Tạm truyền từ Frontend lên vì chưa làm Authen
    private List<QuestionDto> questions; // Danh sách câu hỏi gửi kèm khi tạo đề
}
