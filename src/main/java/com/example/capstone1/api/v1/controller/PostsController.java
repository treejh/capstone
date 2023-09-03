package com.example.capstone1.api.v1.controller;

import com.example.capstone1.api.v1.dto.Response;
import com.example.capstone1.api.v1.dto.request.PostRequestDto;
import com.example.capstone1.api.v1.dto.response.PostResponseDto;
import com.example.capstone1.api.v1.service.PostsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
@RestController
public class PostsController {
    private final PostsService postsService;
    private final Response response;

    @GetMapping
    public ResponseEntity<?> getAllPosts() {
        List<PostResponseDto.PostInfoForBlock> postInfos = postsService.getAllPosts();
        return response.success(postInfos, "전체 게시글 조회에 성공했습니다.");
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid PostRequestDto.Create create) {
        postsService.create(create);
        return response.success("게시글 작성에 성공했습니다.");
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable Long postId) {
        PostResponseDto.PostInfo postInfo = postsService.getPostById(postId);
        return response.success(postInfo, "게시글 조회에 성공했습니다.");
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<?> update(@PathVariable Long postId,
                                    @Valid PostRequestDto.Update update) {
        postsService.update(update, postId);
        return response.success("게시글 수정에 성공했습니다.");
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> delete(@PathVariable Long postId) {
        postsService.delete(postId);
        return response.success("게시글 삭제에 성공했습니다.");
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchPosts(String query) {
        List<PostResponseDto.PostInfoForBlock> postInfos = postsService.searchPosts(query);
        return response.success(postInfos, "게시글 조회에 성공했습니다.");
    }
}
