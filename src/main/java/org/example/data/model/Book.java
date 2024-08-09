package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Book {
    @Id
    private String Id;
    private String title;
    private String author;
    private String isbn;
    private String publishDate;
    private Category type;
    private boolean isAvailable=true;
    private LocalDateTime localDateTime;
}



