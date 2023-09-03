package com.example.capstone1.api.v1.chat.controller;



import com.example.capstone1.api.v1.chat.dto.ChatRequestDto;
import com.example.capstone1.api.v1.chat.dto.ChatResponseDto;
import com.example.capstone1.api.v1.chat.entity.ChatEntity;
import com.example.capstone1.api.v1.chat.mapper.ChatMapper;
import com.example.capstone1.api.v1.chat.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@Validated
@AllArgsConstructor
public class ChatController {
    private final ChatService chatService;
    private final ChatMapper chatMapper;

    // Create
    @PostMapping
    public ResponseEntity postChat(@Valid @RequestBody ChatRequestDto.Post post) {
        ChatEntity chat = chatService.craeteChat(chatMapper.ChatDtoPostToChat(post));
        ChatResponseDto.Response response = chatMapper.ChatToChatDtoResponse(chat);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Read
    @GetMapping
    public ResponseEntity getChat(@Positive @RequestParam int chatId) {
        ChatEntity chat = chatService.findChat(chatId);
        ChatResponseDto.Response response = chatMapper.ChatToChatDtoResponse(chat);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Update
    @PatchMapping("/{chat-id}")
    public ResponseEntity patchChat(@Positive @PathVariable("chat-id") int chatId,
                                      @RequestBody ChatRequestDto.Patch patch) {
        patch.setChatId(chatId);
        ChatEntity chat = chatService.patchChat(chatMapper.ChatDtoPatchToChat(patch));
        ChatResponseDto.Response response = chatMapper.ChatToChatDtoResponse(chat);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
/*
    @PutMapping("/{chat-id}")
    public ResponseEntity putChat(@Positive @PathVariable("chat-id") long chatId,
                                    @Valid @RequestBody ChatDto.Put put) {
        put.setChatId(chatId);
        ChatEntity chat = chatService.putChat(chatMapper.chatDtoPutToChat(put));
        ChatDto.Response response = chatMapper.chatToChatDtoResponse(chat);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


 */
    // Delete
    @DeleteMapping("/{chat-id}")
    public ResponseEntity deleteChat(@Positive @PathVariable("chat-id") int chatId) {
        chatService.deleteChat(chatId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
