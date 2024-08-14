package org.example.dto.response;

import lombok.Data;
import org.example.data.model.Category;

import java.time.LocalDateTime;
@Data
public class AddBookResponse {
    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private Category type;
    private LocalDateTime localDateTime;
    private String message="";
}
