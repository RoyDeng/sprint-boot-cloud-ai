package com.roydevelop.ai.payload.base;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message implements Serializable {
    private String role;
    private String content;
}
