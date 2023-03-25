package com.roydevelop.ai.payload.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class WhisperTranscriptionResponse implements Serializable {
    private String text;
}
