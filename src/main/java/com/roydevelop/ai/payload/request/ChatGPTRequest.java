package com.roydevelop.ai.payload.request;

import java.io.Serializable;
import java.util.List;

import com.roydevelop.ai.payload.base.Message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatGPTRequest implements Serializable {
    private String model;
    private List<Message> messages;
}
