package com.military.english.mapper;

import com.military.english.entity.Question;
import com.military.english.model.QuestionDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-31T21:23:14+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.200.v20261008-1115, environment: Java 25.0.4.1 (Eclipse Adoptium)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public QuestionDto toDto(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionDto questionDto = new QuestionDto();

        questionDto.setContent( question.getContent() );
        questionDto.setCorrectOption( question.getCorrectOption() );
        questionDto.setExplanation( question.getExplanation() );
        questionDto.setId( question.getId() );
        questionDto.setOptionA( question.getOptionA() );
        questionDto.setOptionB( question.getOptionB() );
        questionDto.setOptionC( question.getOptionC() );
        questionDto.setOptionD( question.getOptionD() );

        return questionDto;
    }

    @Override
    public Question toEntity(QuestionDto questionDto) {
        if ( questionDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setContent( questionDto.getContent() );
        question.setCorrectOption( questionDto.getCorrectOption() );
        question.setExplanation( questionDto.getExplanation() );
        question.setId( questionDto.getId() );
        question.setOptionA( questionDto.getOptionA() );
        question.setOptionB( questionDto.getOptionB() );
        question.setOptionC( questionDto.getOptionC() );
        question.setOptionD( questionDto.getOptionD() );

        return question;
    }
}
