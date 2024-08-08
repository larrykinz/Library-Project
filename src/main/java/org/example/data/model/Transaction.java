package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Transaction {
    @Id
    private String transactionId;
    private String bookId;
    private String memberId;
    private String borrowDate;
    private String returnDate;
}
