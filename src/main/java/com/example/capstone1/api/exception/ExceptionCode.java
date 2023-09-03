package com.example.capstone1.api.exception;

import lombok.Getter;

public enum ExceptionCode {
     MEMBER_NOT_FOUND(404, "Chat not found");

    @Getter
    private double status;

    @Getter
    private String message;

    ExceptionCode(double code, String message) {
        this.status = code;
        this.message = message;
    }
}