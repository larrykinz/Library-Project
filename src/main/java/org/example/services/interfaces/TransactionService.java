package org.example.services.interfaces;

import org.example.dto.request.FindTransactionRequest;
import org.example.dto.request.RecordTransactionRequest;
import org.example.dto.response.FindTransactionResponse;
import org.example.dto.response.RecordTransactionResponse;

public interface TransactionService {
    public RecordTransactionResponse recordTransaction(RecordTransactionRequest recordTransactionRequest);

    public FindTransactionResponse findTransaction(FindTransactionRequest findTransactionRequest);
}
