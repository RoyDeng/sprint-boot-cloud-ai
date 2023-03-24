package com.roydevelop.ai.payload.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.roydevelop.ai.payload.base.Choice;
import com.roydevelop.ai.payload.base.Usage;

import lombok.Data;

@Data
public class ChatGPTResponse implements Serializable {
    private String id;
    private String object;
    private String model;
    private LocalDate created;
    private List<Choice> choices;
    private Usage usage;
}
