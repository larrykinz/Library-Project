package org.example.dto.response;

import lombok.Data;
import org.example.data.model.Category;

@Data
public class RecordTransactionResponse {
    private String transactionId;
    private String transactionType;
    private String transactionStatus;
    private String message ="";

}
