package com.example.capstone1.api.security;

import com.example.capstone1.api.exception.CustomException;
import com.example.capstone1.api.exception.ErrorCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static String getCurrentUsername() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw new CustomException(ErrorCode.UNAUTHORIZED_USER);
        }
        return authentication.getName();
    }
}
