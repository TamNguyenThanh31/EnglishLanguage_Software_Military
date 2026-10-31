package com.military.english.mapper;

import com.military.english.entity.Question;
import com.military.english.model.QuestionDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {
    QuestionDto toDto(Question question);

    Question toEntity(QuestionDto questionDto);
}
