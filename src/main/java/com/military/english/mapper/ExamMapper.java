package com.military.english.mapper;

import com.military.english.entity.Exam;
import com.military.english.model.ExamDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExamMapper {
    @Mapping(source = "teacher.id", target = "teacherId")
    ExamDto toDto(Exam exam);
}
