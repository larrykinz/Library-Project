package org.example.dto.response;

import lombok.Data;

@Data
public class BorrowBookResponse {
    private String title;
    private String author;
    private String isbn;
    private String id;
}
