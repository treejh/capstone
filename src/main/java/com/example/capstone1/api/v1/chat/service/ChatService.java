package com.example.capstone1.api.v1.chat.service;

import com.example.capstone1.api.exception.BusinessLogicException;
import com.example.capstone1.api.exception.ExceptionCode;
import com.example.capstone1.api.v1.chat.entity.ChatEntity;
import com.example.capstone1.api.v1.chat.repository.ChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    //Create
    public ChatEntity craeteChat(ChatEntity chat) {
        if(findByEmail(chat.getEmail()) != null)
            return findByEmail(chat.getEmail());

        return chatRepository.save(chat);
    }

    // Read
    public ChatEntity findChat(int chatId) {
        ChatEntity chat = verifiedChat(chatId);
        return chat;
    }

    // email로 user 정보 조회
    public ChatEntity findByEmail(String email) {
        Optional<ChatEntity> optionalUser = chatRepository.findByEmail(email);
        ChatEntity chat = optionalUser.orElse(null);

        return chat;
    }

    // Update
    public ChatEntity patchChat(ChatEntity chat) {
        ChatEntity findChat = verifiedChat(chat.getChatId());
        Optional.ofNullable(chat.getName()).ifPresent(findChat::setName);
        Optional.ofNullable(chat.getEmail()).ifPresent(findChat::setEmail);
        Optional.ofNullable(chat.getPay()).ifPresent(findChat::setPay);
        Optional.ofNullable(chat.getTemperature()).ifPresent(findChat::setTemperature);
        Optional.ofNullable(chat.getImage()).ifPresent(findChat::setImage);

        return chatRepository.save(findChat);
    }
/*
    public ChatEntity putChat(ChatEntity chat) {
        ChatEntity findChat = verifiedChat(chat.getChatId());
        findChat.setEmail(chat.getEmail());
        findChat.setName(chat.getName());
        findChat.setPay(chat.getPay());
        findChat.setTemperature(chat.getTemperature());
        findChat.setImage(chat.getImage());

        return chatRepository.save(findChat);
    }

 */

    // Delete
    public void deleteChat(int chatId) {
        ChatEntity chat = verifiedChat(chatId);
        chatRepository.delete(chat);
    }

    // 멤버 검증
    public ChatEntity verifiedChat(int chatId) {
        Optional<ChatEntity> chat = chatRepository.findById(chatId);
        return chat.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }



}
