package com.example.capstone1.api.mapper;

import com.example.capstone1.api.entity.Users;
import com.example.capstone1.api.entity.Users.UsersBuilder;
import com.example.capstone1.api.v1.dto.request.UserRequestDto.SignUp;
import com.example.capstone1.api.v1.dto.response.UserResponseDto.UserInfo;
import com.example.capstone1.api.v1.dto.response.UserResponseDto.UserInfoForSearching;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-09T17:35:47+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.19 (Azul Systems, Inc.)"
)
@Component
public class UsersMapperImpl implements UsersMapper {

    @Override
    public Users toUser(SignUp signUp) {
        if ( signUp == null ) {
            return null;
        }

        UsersBuilder users = Users.builder();

        users.username( signUp.getUsername() );
        users.password( signUp.getPassword() );
        users.email( signUp.getEmail() );

        users.roles( java.util.Collections.singletonList(com.example.capstone1.api.enums.Authority.ROLE_USER.name()) );

        return users.build();
    }

    @Override
    public UserInfo toUserInfo(Users user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String username = null;
        String email = null;
        String introduction = null;

        id = user.getId();
        username = user.getUsername();
        email = user.getEmail();
        introduction = user.getIntroduction();

        UserInfo userInfo = new UserInfo( id, username, email, introduction );

        return userInfo;
    }

    @Override
    public UserInfoForSearching toUserInfoForSearching(Users user) {
        if ( user == null ) {
            return null;
        }

        String id = null;
        String username = null;

        if ( user.getId() != null ) {
            id = String.valueOf( user.getId() );
        }
        username = user.getUsername();

        UserInfoForSearching userInfoForSearching = new UserInfoForSearching( id, username );

        return userInfoForSearching;
    }
}
