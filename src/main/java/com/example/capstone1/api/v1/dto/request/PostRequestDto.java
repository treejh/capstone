package com.example.capstone1.api.v1.dto.request;

import com.example.capstone1.api.enums.Position;
import com.example.capstone1.api.enums.TechStack;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PostRequestDto {

    @Getter
    @Setter
    public static class Create {

        @NotBlank(message = "제목을 입력해주세요")
        private String title;
        @NotBlank(message = "내용을 입력해주세요")
        private String content;

        @NotNull
        private int recruitmentSize;

        @NotEmpty
        private List<Position> position;

        @NotEmpty
        private List<TechStack> techStack;

        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate recruitmentPeriod;

        @NotNull
        private int expectedDuration;
    }

    @Getter
    @Setter
    public static class Update {

        private Optional<String> title = Optional.empty();
        private Optional<String> content = Optional.empty();
        private Optional<Integer> recruitmentSize = Optional.empty();
        private Optional<List<Position>> position = Optional.empty();
        private Optional<List<TechStack>> techStack = Optional.empty();
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Optional<LocalDate> recruitmentPeriod = Optional.empty();
        private Optional<Integer> expectedDuration = Optional.empty();
    }
}
