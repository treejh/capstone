package com.example.capstone1.api.v1.dto.response;

import com.example.capstone1.api.enums.Position;
import com.example.capstone1.api.enums.TechStack;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class PostResponseDto {

    @Getter
    @Setter
    public static class PostInfo {
        private Long id;
        private Long userId;
        private String username;
        private String title;
        private String content;
        private int recruitmentSize;
        private List<Position> position;
        private List<TechStack> techStack;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate recruitmentPeriod;
        private int expectedDuration;
    }

    @Getter
    @Setter
    public static class PostInfoForBlock {
        private Long id;
        private Long userId;
        private String username;
        private String title;
        private List<Position> position;
        private List<TechStack> techStack;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate recruitmentPeriod;
    }
}
