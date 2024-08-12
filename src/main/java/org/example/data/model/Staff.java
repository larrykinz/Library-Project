package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Staff {
    @Id
    private String staffId;
    private String staffName;
    private String password;
    private String email;
    private boolean loggedin;
}
