package org.example.dto.request;

import lombok.Data;

@Data
public class UpdateBookRequest {
    private String Id;
    private String title;
    private String author;
    private String isbn;
    private String type;




}
