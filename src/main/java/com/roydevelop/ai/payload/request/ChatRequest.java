package com.roydevelop.ai.payload.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class ChatRequest implements Serializable {
    private String question;
}

