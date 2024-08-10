package org.example.services.implementation;

import org.example.data.model.Transaction;
import org.example.data.repository.TransactionRepository;
import org.example.dto.request.FindTransactionRequest;
import org.example.dto.request.RecordTransactionRequest;
import org.example.dto.response.FindTransactionResponse;
import org.example.dto.response.RecordTransactionResponse;
import org.example.exception.BookAlreadyExistException;
import org.example.exception.RecordTransactionException;
import org.example.services.interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;

@Service
public class Transactionimpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public RecordTransactionResponse recordTransaction(RecordTransactionRequest recordTransactionRequest){
        for(Transaction transaction : transactionRepository.findAll()) {
            if (transaction.getTransactionId().equals(recordTransactionRequest.getTransactionId())) {
                transaction.setTransactionId(transaction.getTransactionId());
                transaction.setBookId(transaction.getBookId());
                transaction.setBorrowDate(transaction.getBorrowDate());
                transaction.setReturnDate(transaction.getReturnDate());
                transaction.setMemberId(transaction.getMemberId());
                transactionRepository.save(transaction);
            }
            throw new RecordTransactionException("Transaction does not exist");

        }
        RecordTransactionResponse recordTransactionResponse = new RecordTransactionResponse();
        recordTransactionResponse.setMessage("Successfully recorded transaction");
        recordTransactionResponse.setTransactionType(recordTransactionResponse.getTransactionType());
        recordTransactionResponse.setTransactionId(recordTransactionResponse.getTransactionId());
        return recordTransactionResponse;
    }
    public FindTransactionResponse findTransaction(FindTransactionRequest findTransactionRequest){
        for(Transaction transaction : transactionRepository.findAll()) {
            if (transaction.getTransactionId().equals(findTransactionRequest.getTransactionId())) {
                transaction.setTransactionId(transaction.getTransactionId());
                transactionRepository.save(transaction);
            }
        }
        FindTransactionResponse findTransactionResponse = new FindTransactionResponse();
        findTransactionResponse.setTransactionId(findTransactionRequest.getTransactionId());
        findTransactionResponse.setMessage("Successfully found transaction");
        return findTransactionResponse;

    }
}
