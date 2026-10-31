package com.military.english.mapper;

import com.military.english.entity.Question;
import com.military.english.model.QuestionDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-31T20:55:26+0700",
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

        questionDto.setId( question.getId() );
        questionDto.setContent( question.getContent() );
        questionDto.setOptionA( question.getOptionA() );
        questionDto.setOptionB( question.getOptionB() );
        questionDto.setOptionC( question.getOptionC() );
        questionDto.setOptionD( question.getOptionD() );
        questionDto.setCorrectOption( question.getCorrectOption() );
        questionDto.setExplanation( question.getExplanation() );

        return questionDto;
    }

    @Override
    public Question toEntity(QuestionDto questionDto) {
        if ( questionDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setId( questionDto.getId() );
        question.setContent( questionDto.getContent() );
        question.setOptionA( questionDto.getOptionA() );
        question.setOptionB( questionDto.getOptionB() );
        question.setOptionC( questionDto.getOptionC() );
        question.setOptionD( questionDto.getOptionD() );
        question.setCorrectOption( questionDto.getCorrectOption() );
        question.setExplanation( questionDto.getExplanation() );

        return question;
    }
}
