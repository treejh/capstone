package com.example.capstone1.api.v1.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ChatResponseDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response {
        private int chatId;
        private String email;
        private String name;
        private String pay;
        private float temperature;
        private String image;
    }
}
