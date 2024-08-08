package org.example.dto.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String password;
    private String staffName;
    private boolean isLoggedIn=true;
}
