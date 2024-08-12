package org.example.dto.request;

import lombok.Data;

@Data
public class SearchBookRequest {
    private String title;
    private String author;
    private String isbn;
}
