package com.roydevelop.ai.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roydevelop.ai.payload.request.ChatRequest;
import com.roydevelop.ai.payload.request.TranscriptionRequest;
import com.roydevelop.ai.payload.response.ChatGPTResponse;
import com.roydevelop.ai.payload.response.WhisperTranscriptionResponse;
import com.roydevelop.ai.service.OpenAIClientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class OpenAIController {
    private final OpenAIClientService openAIClientService;

    @PostMapping(value = "/chat", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChatGPTResponse chat(@RequestBody ChatRequest request) {
        return openAIClientService.chat(request);
    }

    @PostMapping(value = "/transcription", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public WhisperTranscriptionResponse createTranscription(@ModelAttribute TranscriptionRequest request){
        return openAIClientService.createTranscription(request);
    }
}
