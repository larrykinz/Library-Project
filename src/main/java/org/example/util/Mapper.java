package org.example.util;

import org.example.data.model.Book;
import org.example.data.model.Staff;
import org.example.dto.request.AddBookRequest;
import org.example.dto.request.DeleteBookRequest;
import org.example.dto.request.RegisterRequest;
import org.example.dto.request.UpdateBookRequest;
import org.example.dto.response.AddBookResponse;
import org.example.dto.response.DeleteBookResponse;
import org.example.dto.response.RegisterResponse;
import org.example.dto.response.UpdateBookResponse;

import java.time.LocalDateTime;

public class Mapper {
    public static Book map(AddBookRequest addbookRequest) {
        Book newBook = new Book();
        newBook.setTitle(addbookRequest.getTitle());
        newBook.setAuthor(addbookRequest.getAuthor());
        newBook.setIsbn(addbookRequest.getIsbn());
        newBook.setStatus(addbookRequest.getType());
        return newBook;
    }

    public static AddBookResponse getAddBookResponse(Book newBook) {
        AddBookResponse addBookResponse = new AddBookResponse();
        addBookResponse.setBookId(newBook.getId());
        addBookResponse.setTitle(newBook.getTitle());
        addBookResponse.setAuthor(newBook.getAuthor());
        addBookResponse.setIsbn(newBook.getIsbn());
        addBookResponse.setLocalDateTime(LocalDateTime.now());
        return addBookResponse;
    }

    public static Book mapUpdate(UpdateBookRequest updateBookRequest) {
        Book book = new Book();
        book.setTitle(updateBookRequest.getTitle());
        book.setAuthor(updateBookRequest.getAuthor());
        book.setIsbn(updateBookRequest.getIsbn());
        return book;
    }

    public static UpdateBookResponse getUpdateBookResponse(UpdateBookRequest updateBookRequest, Book book) {
        UpdateBookResponse newUpdateBook = new UpdateBookResponse();
        newUpdateBook.setBookId(book.getId());
        newUpdateBook.setAuthor(book.getAuthor());
        newUpdateBook.setIsbn(updateBookRequest.getIsbn());
        newUpdateBook.setType(book.getStatus());
        newUpdateBook.setLocalDateTime(LocalDateTime.now());
        return newUpdateBook;
    }

    public static Staff mapStaff(RegisterRequest registerRequest) {
        Staff staff = new Staff();
        staff.setStaffName(registerRequest.getStaffName());
        staff.setPassword(registerRequest.getPassword());
        staff.setEmail(registerRequest.getEmail());
        return staff;
    }

    public static RegisterResponse getRegisterResponse(Staff staff) {
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setStaffId(staff.getStaffId());
        registerResponse.setStaffName(staff.getStaffName());
        registerResponse.setPassword(staff.getPassword());
        registerResponse.setEmail(staff.getEmail());
        return registerResponse;
    }

    public static DeleteBookResponse getDeleteBookResponse(DeleteBookRequest deleteBookRequest) {
        DeleteBookResponse newDeleteBook = new DeleteBookResponse();
        newDeleteBook.setMessage("Book deleted successfully");
        newDeleteBook.setLocalDateTime(LocalDateTime.now());
        return newDeleteBook;
    }

}
