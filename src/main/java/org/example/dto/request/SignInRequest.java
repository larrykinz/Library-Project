package org.example.dto.request;

import lombok.Data;

@Data
public class SignInRequest {
    private String name;
    private String password;
    private String MemberId;
}
