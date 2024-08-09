package org.example.dto.response;

import lombok.Data;

@Data
public class ReturnBookResponse {
   private String bookId;
    private String title;
    private String author;
    private String isbn;
}
