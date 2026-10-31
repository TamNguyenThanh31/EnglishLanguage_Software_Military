package com.military.english.entity;

import com.military.english.enums.NoiseType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lessons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    private String title;
    private String lessonType;

    @Column(columnDefinition = "TEXT")
    private String contentText;

    private String originalAudioUrl;
    private String mixedAudioUrl;

    @Enumerated(EnumType.STRING)
    private NoiseType noiseType;
}
