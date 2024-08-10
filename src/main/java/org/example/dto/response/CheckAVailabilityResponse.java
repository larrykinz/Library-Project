package org.example.dto.response;

import lombok.Data;

@Data
public class CheckAVailabilityResponse {
    private boolean isAvailable;
    private String message="";

}
