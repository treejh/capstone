package com.example.capstone1.api.v1.chat.controller;

// import 생략...

import com.example.capstone1.api.v1.chat.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatController { //message controller

    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage = message;
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
            chatMessage.setMessage(message.getSender() + "님이 입장하셨습니다.");
        }
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), chatMessage);
    }
}