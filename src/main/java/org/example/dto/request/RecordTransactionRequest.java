package org.example.dto.request;

import lombok.Data;

@Data
public class RecordTransactionRequest {
    private String TransactionId;
    private String borrowDate;
    private String returnDate;
    private String transactionAmount;

}
