package org.example.services.implementation;

import org.example.data.model.Book;
import org.example.data.repository.BookRepository;
import org.example.dto.request.CheckAvailabilityRequest;
import org.example.dto.request.UpdateAvailabilityRequest;
import org.example.dto.response.CheckAVailabilityResponse;
import org.example.dto.response.UpdateAvailabilityResponse;
import org.example.exception.BookUpdateAvailabilityException;
import org.example.exception.CheckAvailabilityException;
import org.example.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    public CheckAVailabilityResponse checkAVailability(CheckAvailabilityRequest checkAvailabilityRequest){
        for(Book book : bookRepository.findAll()){
            if(book.getId().equals(checkAvailabilityRequest.getId())){
                book.setId(book.getId());
                book.setTitle(book.getTitle());
                bookRepository.save(book);
            }
            throw new CheckAvailabilityException("Book isnt Available");
        }
        CheckAVailabilityResponse checkAVailabilityResponse = new CheckAVailabilityResponse();
        checkAVailabilityResponse.setAvailable(true);
        checkAVailabilityResponse.setMessage("Book Available");
        return checkAVailabilityResponse;

    }
    public UpdateAvailabilityResponse updateAvailability(UpdateAvailabilityRequest updateAvailabilityRequest){
        for(Book book : bookRepository.findAll()){
            if(book.getId().equals(updateAvailabilityRequest.getId())){
                book.setId(updateAvailabilityRequest.getId());
                book.setTitle(updateAvailabilityRequest.getTitle());
                bookRepository.save(book);
            }
            throw new BookUpdateAvailabilityException("Update failed book not found");
        }
        UpdateAvailabilityResponse updateAvailabilityResponse = new UpdateAvailabilityResponse();
        updateAvailabilityResponse.setMessage("Updated succesfully");
        return updateAvailabilityResponse;
    }
}
