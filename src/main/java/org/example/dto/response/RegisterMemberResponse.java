package org.example.dto.response;

import lombok.Data;

@Data

public class RegisterMemberResponse {
    private String message;
    private String name;
    private String password;
}
