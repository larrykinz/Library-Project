package org.example.dto.response;

import lombok.Data;

@Data
public class RegisterResponse {
    private String staffId;
    private String staffName;
    private String email;
    private String password;
}
