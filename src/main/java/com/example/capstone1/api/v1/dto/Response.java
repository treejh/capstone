package com.example.capstone1.api.v1.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;

@Component
public class Response {

    @Getter
    @Builder
    private static class Body {

        private final LocalDateTime timestamp = LocalDateTime.now();
        private Integer status;
        private String message;
        private Object data;
    }

    public ResponseEntity<?> success(Object data, String msg) {
        Body body = Body.builder()
                .status(HttpStatus.OK.value())
                .data(data)
                .message(msg)
                .build();
        return ResponseEntity.ok(body);
    }

    /**
     * <p> 메세지만 가진 성공 응답을 반환한다.</p>
     * <pre>
     *     {
     *         "status" : 200,
     *         "message" : message,
     *         "data" : [],
     *     }
     * </pre>
     *
     * @param msg 응답 바디 message 필드에 포함될 정보
     * @return 응답 객체
     */
    public ResponseEntity<?> success(String msg) {
        return success(Collections.emptyList(), msg);
    }

    /**
     * <p> 데이터만 가진 성공 응답을 반환한다.</p>
     * <pre>
     *     {
     *         "status" : 200,
     *         "message" : null,
     *         "data" : [{data1}, {data2}...],
     *     }
     * </pre>
     *
     * @param data 응답 바디 data 필드에 포함될 정보
     * @return 응답 객체
     */
    public ResponseEntity<?> success(Object data) {
        return success(data, null);
    }

    /**
     * <p> 성공 응답만 반환한다. </p>
     * <pre>
     *     {
     *         "status" : 200,
     *         "message" : null,
     *         "data" : [],
     *     }
     * </pre>
     *
     * @return 응답 객체
     */
    public ResponseEntity<?> success() {
        return success(Collections.emptyList(), null);
    }
}