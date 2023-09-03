package com.example.capstone1.api.v1.repository;

import com.example.capstone1.api.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p WHERE p.title LIKE %?1% OR p.content LIKE %?1%")
    List<Posts> findByTitleContainingOrContentContaining(String query);
}
