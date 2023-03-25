package com.roydevelop.ai.openai;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.roydevelop.ai.config.openai.OpenAIClientConfig;
import com.roydevelop.ai.payload.request.ChatGPTRequest;
import com.roydevelop.ai.payload.request.WhisperTranscriptionRequest;
import com.roydevelop.ai.payload.response.ChatGPTResponse;
import com.roydevelop.ai.payload.response.WhisperTranscriptionResponse;

@FeignClient(
    name = "openai-service",
    url = "${openai-service.urls.base-url}",
    configuration = OpenAIClientConfig.class
)
public interface OpenAIClient {
    @PostMapping(value = "${openai-service.urls.chat-url}", headers = {"Content-Type=application/json"})
    ChatGPTResponse chat(@RequestBody ChatGPTRequest request);

    @PostMapping(value = "${openai-service.urls.create-transcription-url}", headers = {"Content-Type=multipart/form-data"})
    WhisperTranscriptionResponse createTranscription(@ModelAttribute WhisperTranscriptionRequest request);
}
