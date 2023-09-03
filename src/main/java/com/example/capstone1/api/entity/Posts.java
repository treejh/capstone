package com.example.capstone1.api.entity;

import com.example.capstone1.api.enums.Position;
import com.example.capstone1.api.enums.TechStack;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Posts extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = LAZY)
    @JoinColumn
    private Users user;

    @Column(nullable = false)
    @Size(max = 50)
    private String title;

    @Column(nullable = false)
    @Size(max = 500)
    @Lob
    private String content;

    @Column(nullable = false)
    private int recruitmentSize;

    @Column(nullable = false)
    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private List<Position> position;

    @Column(nullable = false)
    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private List<TechStack> techStack;

    @Column(nullable = false)
    private LocalDate recruitmentPeriod;

    @Column(nullable = false)
    private int expectedDuration;
}
