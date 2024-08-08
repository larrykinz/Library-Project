package org.example.dto.request;

import lombok.Data;
import org.example.data.model.Category;
@Data
public class AddBookRequest {
    private String title;
    private String author;
    private String isbn;
    private Category type;
}
