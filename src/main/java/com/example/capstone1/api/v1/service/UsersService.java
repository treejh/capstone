package com.example.capstone1.api.v1.service;

import com.example.capstone1.api.entity.Users;
import com.example.capstone1.api.enums.Authority;
import com.example.capstone1.api.exception.CustomException;
import com.example.capstone1.api.jwt.JwtTokenProvider;
import com.example.capstone1.api.mapper.UsersMapper;
import com.example.capstone1.api.security.SecurityUtil;
import com.example.capstone1.api.v1.dto.request.UserRequestDto;
import com.example.capstone1.api.v1.dto.response.UserResponseDto;
import com.example.capstone1.api.v1.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static com.example.capstone1.api.exception.ErrorCode.*;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class UsersService {

    private final CustomUserDetailsService customUserDetailsService;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final RedisTemplate redisTemplate;

    public void signUp(UserRequestDto.SignUp signUp) {
        if (usersRepository.existsByUsername(signUp.getUsername())) {
            throw new CustomException(DUPLICATE_USERNAME);
        }

        if (usersRepository.existsByEmail(signUp.getEmail())) {
            throw new CustomException(DUPLICATE_EMAIL);
        }

        Users user = UsersMapper.INSTANCE.toUser(signUp);
        user.setPassword(passwordEncoder.encode(signUp.getPassword()));

        usersRepository.save(user);
    }

    public UserResponseDto.TokenInfo login(UserRequestDto.Login login) {

        if (!usersRepository.existsByUsername(login.getUsername())) {
            throw new CustomException(USER_NOT_FOUND);
        }

        UsernamePasswordAuthenticationToken authenticationToken = login.toAuthentication();

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        UserResponseDto.TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        redisTemplate.opsForValue()
                .set("RT:" + authentication.getName(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);

        return tokenInfo;
    }

    public UserResponseDto.TokenInfo reissue(String accessToken, String refreshToken) {
        if (!jwtTokenProvider.validateToken(refreshToken)) {
            throw new CustomException(BAD_TOKEN_FORMAT);
        }

        Authentication authentication = jwtTokenProvider.getAuthentication(accessToken);

        String redisRefreshToken = (String)redisTemplate.opsForValue().get("RT:" + authentication.getName());

        if(ObjectUtils.isEmpty(redisRefreshToken)) {
            throw new CustomException(REFRESH_TOKEN_NOT_FOUND);
        }

        if(!redisRefreshToken.equals(refreshToken)) {
            throw new CustomException(MISMATCH_REFRESH_TOKEN);
        }

        UserResponseDto.TokenInfo tokenInfo = jwtTokenProvider.generateAccessToken(authentication, refreshToken);

        redisTemplate.opsForValue()
                .set("RT:" + authentication.getName(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);

        return tokenInfo;
    }

    public void logout(String accessToken) {
        if (!jwtTokenProvider.validateToken(accessToken)) {
            throw new CustomException(BAD_TOKEN_FORMAT);
        }

        Authentication authentication = jwtTokenProvider.getAuthentication(accessToken);

        if (redisTemplate.opsForValue().get("RT:" + authentication.getName()) != null) {
            redisTemplate.delete("RT:" + authentication.getName());
        }

        Long expiration = jwtTokenProvider.getExpiration(accessToken);
        redisTemplate.opsForValue()
                .set(accessToken, "logout", expiration, TimeUnit.MILLISECONDS);
    }

    public void authority() {
        String username = SecurityUtil.getCurrentUsername();

        Users user = (Users) customUserDetailsService.loadUserByUsername(username);

        user.getRoles().add(Authority.ROLE_ADMIN.name());
        usersRepository.save(user);
    }

    public void updateMyUserInfo(UserRequestDto.Update update) {
        String username = SecurityUtil.getCurrentUsername();
        Users user = (Users) customUserDetailsService.loadUserByUsername(username);

        if (update.getOldPassword() != null) {
            if (update.getNewPassword() == null) {
                throw new CustomException(OLD_PASSWORD_REQUIRED);
            }

            if (!passwordEncoder.matches(update.getOldPassword(), user.getPassword())) {
                throw new CustomException(MISMATCH_PASSWORD);
            }

            String newPassword = update.getNewPassword();
            user.setPassword(passwordEncoder.encode(newPassword));
        }
        if (update.getNewPassword() != null && update.getOldPassword() == null) {
            throw new CustomException(NEW_PASSWORD_REQUIRED);
        }

        if (update.getIntroduction() != null)
                user.setIntroduction(update.getIntroduction());

        usersRepository.save(user);
    }

    public UserResponseDto.UserInfo getUserInfoById(Long userId) {
        Optional<Users> optionalUser = usersRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new CustomException(USER_NOT_FOUND);
        }

        Users user = optionalUser.get();

        UserResponseDto.UserInfo userInfo = UsersMapper.INSTANCE.toUserInfo(user);

        return userInfo;
    }

    public List<UserResponseDto.UserInfoForSearching> searchUsers(String query) {
        List<Users> users = usersRepository.findByUsernameContaining(query);
        if (users.isEmpty()) {
            return Collections.emptyList();
        }
        else {
            List<UserResponseDto.UserInfoForSearching> userInfos = new ArrayList<>();
            for (Users user : users) {
                UserResponseDto.UserInfoForSearching userInfo = UsersMapper.INSTANCE.toUserInfoForSearching(user);
                userInfos.add(userInfo);
            }
            return userInfos;
        }
    }
}
