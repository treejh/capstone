package com.example.capstone1.api.v1.chat.repository;

import com.example.capstone1.api.v1.chat.entity.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRepository extends JpaRepository<ChatEntity,Integer> {
    Optional<ChatEntity> findByEmail(String email);
}
