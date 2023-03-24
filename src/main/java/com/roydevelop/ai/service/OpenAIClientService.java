package com.roydevelop.ai.service;

import java.util.Collections;

import org.springframework.stereotype.Service;

import com.roydevelop.ai.config.openai.OpenAIClientConfig;
import com.roydevelop.ai.openai.OpenAIClient;
import com.roydevelop.ai.payload.base.Message;
import com.roydevelop.ai.payload.request.ChatGPTRequest;
import com.roydevelop.ai.payload.request.ChatRequest;
import com.roydevelop.ai.payload.response.ChatGPTResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OpenAIClientService {
    private final OpenAIClient openAIClient;
    private final OpenAIClientConfig openAIClientConfig;

    public ChatGPTResponse chat(ChatRequest chatRequest){
        Message message = Message.builder()
                .role("user")
                .content(chatRequest.getQuestion())
                .build();
        ChatGPTRequest chatGPTRequest = ChatGPTRequest.builder()
                .model(openAIClientConfig.getModel())
                .messages(Collections.singletonList(message))
                .build();
        return openAIClient.chat(chatGPTRequest);
    }
}
