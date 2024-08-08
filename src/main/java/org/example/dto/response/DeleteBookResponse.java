package org.example.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeleteBookResponse {
    private String message;
    private LocalDateTime localDateTime;

}
