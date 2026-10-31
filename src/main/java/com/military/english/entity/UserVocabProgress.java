package com.military.english.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_vocab_progress")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVocabProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vocab_id")
    private Vocabulary vocabulary;

    private String status;
    private Integer boxNumber;
    private LocalDate nextReviewDate;
}
