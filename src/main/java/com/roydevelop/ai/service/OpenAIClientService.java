package com.roydevelop.ai.service;

import java.util.Collections;

import org.springframework.stereotype.Service;

import com.roydevelop.ai.config.openai.OpenAIClientConfig;
import com.roydevelop.ai.openai.OpenAIClient;
import com.roydevelop.ai.payload.base.Message;
import com.roydevelop.ai.payload.request.ChatGPTRequest;
import com.roydevelop.ai.payload.request.ChatRequest;
import com.roydevelop.ai.payload.request.TranscriptionRequest;
import com.roydevelop.ai.payload.request.WhisperTranscriptionRequest;
import com.roydevelop.ai.payload.response.ChatGPTResponse;
import com.roydevelop.ai.payload.response.WhisperTranscriptionResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OpenAIClientService {
    private final OpenAIClient openAIClient;
    private final OpenAIClientConfig openAIClientConfig;

    public ChatGPTResponse chat(ChatRequest request){
        Message message = Message.builder()
            .role("user")
            .content(request.getQuestion())
            .build();
        ChatGPTRequest chatGPTRequest = ChatGPTRequest.builder()
            .model(openAIClientConfig.getModel())
            .messages(Collections.singletonList(message))
            .build();
        return openAIClient.chat(chatGPTRequest);
    }

    public WhisperTranscriptionResponse createTranscription(TranscriptionRequest request){
        WhisperTranscriptionRequest whisperTranscriptionRequest = WhisperTranscriptionRequest.builder()
            .model(openAIClientConfig.getAudioModel())
            .file(request.getFile())
            .build();
        return openAIClient.createTranscription(whisperTranscriptionRequest);
    }
}
