package com.example.capstone1.api.v1.chat.mapper;


import com.example.capstone1.api.v1.chat.dto.ChatRequestDto;
import com.example.capstone1.api.v1.chat.dto.ChatResponseDto;
import com.example.capstone1.api.v1.chat.entity.ChatEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    ChatResponseDto.Response ChatToChatDtoResponse(ChatEntity Chat);
    ChatEntity ChatDtoPostToChat(ChatRequestDto.Post post);
    ChatEntity ChatDtoPatchToChat(ChatRequestDto.Patch patch);
}
