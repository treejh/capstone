package com.example.capstone1.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* 400 BAD_REQUEST : 잘못된 요청 */
    INVALID_REFRESH_TOKEN(BAD_REQUEST, "리프레시 토큰이 유효하지 않습니다."),
    MISMATCH_REFRESH_TOKEN(BAD_REQUEST, "리프레시 토큰의 유저 정보가 일치하지 않습니다."),
    BAD_TOKEN_FORMAT(BAD_REQUEST, "잘못된 형식의 토큰입니다."),
    MISMATCH_PASSWORD(BAD_REQUEST, "기존 패스워드가 일치하지 않습니다."),
    OLD_PASSWORD_REQUIRED(BAD_REQUEST, "기존 패스워드를 입력해주세요."),
    NEW_PASSWORD_REQUIRED(BAD_REQUEST, "새로운 패스워드를 입력해주세요."),

    /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */
    INVALID_ACCESS_TOKEN(UNAUTHORIZED, "권한 정보가 없는 토큰입니다."),
    EXPIRED_ACCESS_TOKEN(UNAUTHORIZED, "만료된 토큰입니다."),
    UNAUTHORIZED_USER(UNAUTHORIZED, "Authentication 정보가 존재하지 않습니다."),
    MISMATCH_USER(UNAUTHORIZED, "접근 권한이 없습니다."),

    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    USER_NOT_FOUND(NOT_FOUND, "해당 유저 정보를 찾을 수 없습니다."),
    REFRESH_TOKEN_NOT_FOUND(NOT_FOUND, "로그아웃된 사용자입니다."),
    POST_NOT_FOUND(NOT_FOUND, "해당 게시글을 찾을 수 없습니다."),

    /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
    DUPLICATE_RESOURCE(CONFLICT, "데이터가 이미 존재합니다."),
    DUPLICATE_USERNAME(CONFLICT, "이미 회원가입된 아이디입니다."),
    DUPLICATE_EMAIL(CONFLICT, "이미 회원가입된 이메일입니다."),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러입니다.");

    ;

    private final HttpStatus httpStatus;
    private final String detail;
}
