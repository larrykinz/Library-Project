package org.example.dto.request;

import lombok.Data;

@Data
public class UpdateBookRequest {
    private String bookId;
    private String title;
    private String author;
    private String isbn;



}
