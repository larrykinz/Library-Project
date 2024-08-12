package org.example.dto.response;

import lombok.Data;

@Data
public class SignInResponse {
    private String Message= "";
    private String name;
    private String password;
}
