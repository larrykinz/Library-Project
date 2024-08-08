package org.example.services.implementation;

import org.example.data.model.Book;
import org.example.data.model.Staff;
import org.example.data.repository.BookRepository;
import org.example.data.repository.StaffRepository;
import org.example.dto.request.*;
import org.example.dto.response.*;
import org.example.exception.BookAlreadyExistException;
import org.example.exception.BookDoesNotExistException;
import org.example.exception.StaffAlreadyExistException;
import org.example.exception.staffInvalidLoginException;
import org.example.services.interfaces.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static org.example.util.Mapper.*;

@Service
public class StaffServiceImpl implements StaffServices {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Override
    public AddBookResponse addBook(AddBookRequest addbookRequest) {
        for (Book book : bookRepository.findAll()) {
            if (book.getTitle().equals(addbookRequest.getTitle()))
                throw new BookAlreadyExistException("book already exist");
        }
        Book newBook = map(addbookRequest);
        bookRepository.save(newBook);
        return getAddBookResponse(newBook);
    }
    @Override
    public DeleteBookResponse deleteBook(DeleteBookRequest deleteBookRequest) {
        for (Book book : bookRepository.findAll()) {
            if (book.getId().equals(deleteBookRequest.getBookId())){
                bookRepository.delete(book);
            }
            throw new BookDoesNotExistException("book dosen't exist");
        }

        return getDeleteBookResponse(deleteBookRequest);    
    }

    @Override
    public UpdateBookResponse updateBook(UpdateBookRequest updateBookRequest) {
        for (Book book : bookRepository.findAll()) {
            if (book.getId().equals(updateBookRequest.getBookId())){
                bookRepository.delete(book);

            }
            throw new BookDoesNotExistException("book dosen't exist");
        }
        Book book = mapUpdate(updateBookRequest);
        bookRepository.save(book);

        return getUpdateBookResponse(updateBookRequest, book);
    }

    @Override
    public RegisterResponse registerStaff(RegisterRequest registerRequest) {
        for(Staff staff : staffRepository.findAll()) {
            if (staff.getStaffName().equals(registerRequest.getStaffName())) {
                throw new StaffAlreadyExistException("staff already exist");
            }
        }
        Staff staff = mapStaff(registerRequest);
        staffRepository.save(staff);
        return getRegisterResponse(staff);
    }



    @Override
    public LoginResponse loginStaff(LoginRequest loginRequest) {
        for (Staff staff : staffRepository.findAll()) {
            if (staff.getStaffName().equals(loginRequest.getStaffName())) {
                staff.setStaffName(loginRequest.getStaffName());
                staff.setPassword(loginRequest.getPassword());
                staffRepository.save(staff);
            }
            throw new staffInvalidLoginException("INVALID LOGIN");
        }
        return getLoginResponse(loginRequest);

    }

    private static LoginResponse getLoginResponse(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setStaffName(loginRequest.getStaffName());
        loginResponse.setPassword(loginRequest.getPassword());
        loginResponse.setLoggedIn(true);
        return loginResponse;
    }


}
