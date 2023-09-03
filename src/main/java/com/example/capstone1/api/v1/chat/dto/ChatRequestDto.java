package com.example.capstone1.api.v1.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ChatRequestDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Post {
        private long chatId;
        private String email;
        private String name;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {
        private long chatId;
        private String email;
        private String name;
        private String pay;
        private float temperature;
        private String image;
    }
}
