package org.example.dto.request;

import lombok.Data;
import org.example.data.model.Category;

@Data
public class UpdateBookRequest {
    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private Category type;




}
