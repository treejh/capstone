package com.example.capstone1.api.mapper;

import com.example.capstone1.api.entity.Users;
import com.example.capstone1.api.v1.dto.request.UserRequestDto;
import com.example.capstone1.api.v1.dto.response.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

    @Mapping(target = "roles", expression = "java(java.util.Collections.singletonList(com.example.capstone1.api.enums.Authority.ROLE_USER.name()))")
    Users toUser(UserRequestDto.SignUp signUp);

    UserResponseDto.UserInfo toUserInfo(Users user);
    UserResponseDto.UserInfoForSearching toUserInfoForSearching(Users user);
}
