package org.example.services.implementation;

import org.example.data.model.Book;
import org.example.data.model.Staff;
import org.example.data.repository.BookRepository;
import org.example.data.repository.StaffRepository;
import org.example.dto.request.*;
import org.example.dto.response.*;
import org.example.exception.*;
import org.example.services.interfaces.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

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
            if (book.getId().equals(deleteBookRequest.getBookId())) bookRepository.delete(book);
            return getDeleteBookResponse(deleteBookRequest);

        }
        throw new BookDoesNotExistException("book does not exist");
    }

    @Override
    public UpdateBookResponse updateBook(UpdateBookRequest updateBookRequest) {
        Book bookToUpdate = null;
        for (Book book : bookRepository.findAll()) {
            if (book.getId().equals(updateBookRequest.getBookId())) {
                bookToUpdate = book;
                break;
            }
        }
        if (bookToUpdate == null) {
            throw new BookDoesNotExistException("Book doesn't exist");
        }
        bookToUpdate = mapUpdate(updateBookRequest);

        bookRepository.save(bookToUpdate);
        return getUpdateBookResponse(updateBookRequest, bookToUpdate);
    }

    @Override
    public RegisterResponse registerStaff(RegisterRequest registerRequest) {
        if (staffRepository.findStaffByStaffName(registerRequest.getStaffName())!=null){
            throw new StaffAlreadyExistException("Staff already exists");
        }
        Staff staff = mapStaff(registerRequest);
        staffRepository.save(staff);
        return getRegisterResponse(staff);
    }




    @Override
    public LoginResponse loginStaff(LoginRequest loginRequest) {
        Staff staff = staffRepository.findByEmail(loginRequest.getEmail());
        if(staff==null) throw new IllegalArgumentException("User Not Found");
        if(!staff.getPassword().equals(loginRequest.getPassword()))throw new IllegalArgumentException("INVALID Credentials");

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setStaffName(loginRequest.getStaffName());
        loginResponse.setPassword(loginRequest.getPassword());
        loginResponse.setEmail(staff.getEmail());
        loginResponse.setLoggedIn(true);
        return loginResponse;

    }





}
