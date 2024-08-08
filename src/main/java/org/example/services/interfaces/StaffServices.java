package org.example.services.interfaces;

import org.example.dto.request.*;
import org.example.dto.response.*;

public interface StaffServices {
    public AddBookResponse addBook(AddBookRequest addbookRequest);

    public DeleteBookResponse deleteBook(DeleteBookRequest deletebookRequest);

    public UpdateBookResponse updateBook(UpdateBookRequest updateBookRequest);

    public RegisterResponse registerStaff(RegisterRequest registerRequest);

    public LoginResponse loginStaff(LoginRequest loginRequest);
}
