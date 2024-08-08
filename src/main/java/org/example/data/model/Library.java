package org.example.data.model;
import java.util.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class Library {
    @Id
    private String id;
    private String name;
    private String location;
    @DBRef
    private List<String> libraries;
}

