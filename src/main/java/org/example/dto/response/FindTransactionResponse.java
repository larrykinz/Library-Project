package org.example.dto.response;

import lombok.Data;

@Data
public class FindTransactionResponse {
    private String transactionId;
    private String message ="Transaction found";
}
