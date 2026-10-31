package com.military.english.service.impl;

import com.military.english.entity.Exam;
import com.military.english.entity.Question;
import com.military.english.entity.User;
import com.military.english.mapper.ExamMapper;
import com.military.english.mapper.QuestionMapper;
import com.military.english.model.ExamCreateRequest;
import com.military.english.model.ExamDto;
import com.military.english.repository.ExamRepository;
import com.military.english.repository.QuestionRepository;
import com.military.english.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;
    private final ExamMapper examMapper;
    private final QuestionMapper questionMapper;

    @Override
    @Transactional // Đảm bảo lưu thành công cả đề và câu hỏi, lỗi thì rollback toàn bộ
    public ExamDto createExam(ExamCreateRequest request) {
        // 1. Tạo và lưu Exam
        Exam exam = new Exam();
        exam.setTitle(request.getTitle());
        exam.setLevel(request.getLevel());
        exam.setTimeLimitMinutes(request.getTimeLimitMinutes());

        User teacher = new User();
        teacher.setId(request.getTeacherId());
        exam.setTeacher(teacher);

        Exam savedExam = examRepository.save(exam);

        // 2. Map và lưu danh sách Questions
        if (request.getQuestions() != null && !request.getQuestions().isEmpty()) {
            List<Question> questions = request.getQuestions().stream()
                    .map(qDto -> {
                        Question q = questionMapper.toEntity(qDto);
                        q.setExam(savedExam); // Gắn khóa ngoại vào bài thi
                        return q;
                    })
                    .toList();
            questionRepository.saveAll(java.util.Objects.requireNonNull(questions));
        }

        return getExamById(java.util.Objects.requireNonNull(savedExam.getId(), "Saved exam must have an ID"));
    }

    @Override
    public ExamDto getExamById(@org.springframework.lang.NonNull Long id) {
        Exam exam = examRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài thi"));

        ExamDto examDto = examMapper.toDto(exam);

        // Load câu hỏi tương ứng
        List<Question> questions = questionRepository.findByExamId(id);
        examDto.setQuestions(questions.stream().map(questionMapper::toDto).toList());

        return examDto;
    }

    @Override
    public List<ExamDto> getAllExams() {
        // Chỉ trả về thông tin chung của bài thi, không kèm câu hỏi để nhẹ payload
        return examRepository.findAll().stream()
                .map(examMapper::toDto)
                .toList();
    }
}
