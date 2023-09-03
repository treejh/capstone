package com.example.capstone1.api.mapper;

import com.example.capstone1.api.entity.Posts;
import com.example.capstone1.api.entity.Posts.PostsBuilder;
import com.example.capstone1.api.entity.Users;
import com.example.capstone1.api.enums.Position;
import com.example.capstone1.api.enums.TechStack;
import com.example.capstone1.api.v1.dto.request.PostRequestDto.Create;
import com.example.capstone1.api.v1.dto.response.PostResponseDto.PostInfo;
import com.example.capstone1.api.v1.dto.response.PostResponseDto.PostInfoForBlock;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-09T17:35:45+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.19 (Azul Systems, Inc.)"
)
@Component
public class PostsMapperImpl implements PostsMapper {

    @Override
    public Posts toPost(Create create) {
        if ( create == null ) {
            return null;
        }

        PostsBuilder posts = Posts.builder();

        posts.title( create.getTitle() );
        posts.content( create.getContent() );
        posts.recruitmentSize( create.getRecruitmentSize() );
        List<Position> list = create.getPosition();
        if ( list != null ) {
            posts.position( new ArrayList<Position>( list ) );
        }
        List<TechStack> list1 = create.getTechStack();
        if ( list1 != null ) {
            posts.techStack( new ArrayList<TechStack>( list1 ) );
        }
        posts.recruitmentPeriod( create.getRecruitmentPeriod() );
        posts.expectedDuration( create.getExpectedDuration() );

        return posts.build();
    }

    @Override
    public PostInfo toPostInfo(Posts post) {
        if ( post == null ) {
            return null;
        }

        PostInfo postInfo = new PostInfo();

        postInfo.setUserId( postUserId( post ) );
        postInfo.setUsername( postUserUsername( post ) );
        postInfo.setId( post.getId() );
        postInfo.setTitle( post.getTitle() );
        postInfo.setContent( post.getContent() );
        postInfo.setRecruitmentSize( post.getRecruitmentSize() );
        List<Position> list = post.getPosition();
        if ( list != null ) {
            postInfo.setPosition( new ArrayList<Position>( list ) );
        }
        List<TechStack> list1 = post.getTechStack();
        if ( list1 != null ) {
            postInfo.setTechStack( new ArrayList<TechStack>( list1 ) );
        }
        postInfo.setRecruitmentPeriod( post.getRecruitmentPeriod() );
        postInfo.setExpectedDuration( post.getExpectedDuration() );

        return postInfo;
    }

    @Override
    public PostInfoForBlock toPostInfoForBlock(Posts post) {
        if ( post == null ) {
            return null;
        }

        PostInfoForBlock postInfoForBlock = new PostInfoForBlock();

        postInfoForBlock.setUserId( postUserId( post ) );
        postInfoForBlock.setUsername( postUserUsername( post ) );
        postInfoForBlock.setId( post.getId() );
        postInfoForBlock.setTitle( post.getTitle() );
        List<Position> list = post.getPosition();
        if ( list != null ) {
            postInfoForBlock.setPosition( new ArrayList<Position>( list ) );
        }
        List<TechStack> list1 = post.getTechStack();
        if ( list1 != null ) {
            postInfoForBlock.setTechStack( new ArrayList<TechStack>( list1 ) );
        }
        postInfoForBlock.setRecruitmentPeriod( post.getRecruitmentPeriod() );

        return postInfoForBlock;
    }

    private Long postUserId(Posts posts) {
        if ( posts == null ) {
            return null;
        }
        Users user = posts.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String postUserUsername(Posts posts) {
        if ( posts == null ) {
            return null;
        }
        Users user = posts.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }
}
