package org.example.dto.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String staffName;
    private String password;
    private String email;
    private boolean isLoggedIn=true;
}
