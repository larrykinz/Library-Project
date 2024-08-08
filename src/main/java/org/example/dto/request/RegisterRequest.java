package org.example.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String staffName;
    private String password;
    private String email;
}
