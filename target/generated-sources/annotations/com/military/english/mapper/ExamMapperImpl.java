package com.military.english.mapper;

import com.military.english.entity.Exam;
import com.military.english.entity.User;
import com.military.english.model.ExamDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-31T21:23:15+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.200.v20261008-1115, environment: Java 25.0.4.1 (Eclipse Adoptium)"
)
@Component
public class ExamMapperImpl implements ExamMapper {

    @Override
    public ExamDto toDto(Exam exam) {
        if ( exam == null ) {
            return null;
        }

        ExamDto examDto = new ExamDto();

        examDto.setTeacherId( examTeacherId( exam ) );
        examDto.setCreatedAt( exam.getCreatedAt() );
        examDto.setId( exam.getId() );
        examDto.setLevel( exam.getLevel() );
        examDto.setTimeLimitMinutes( exam.getTimeLimitMinutes() );
        examDto.setTitle( exam.getTitle() );

        return examDto;
    }

    private Long examTeacherId(Exam exam) {
        if ( exam == null ) {
            return null;
        }
        User teacher = exam.getTeacher();
        if ( teacher == null ) {
            return null;
        }
        Long id = teacher.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
