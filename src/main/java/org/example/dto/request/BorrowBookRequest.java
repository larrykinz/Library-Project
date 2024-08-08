package org.example.dto.request;

import lombok.Data;

@Data
public class BorrowBookRequest {
    private String title;
    private String author;
    private String isbn;
    private String id;

}
