package org.example.services.interfaces;

import org.example.data.model.Book;
import org.example.dto.request.*;
import org.example.dto.response.*;

import java.util.List;

public interface MemberService {
    public BorrowBookResponse borrowBook(BorrowBookRequest borrowBookRequest);

    public ReturnBookResponse returnBook(ReturnBookRequest returnBookRequest);

    public RegisterMemberResponse registerMember(RegisterMemberRequest registerMemberRequest);

    public SignInResponse signIn(SignInRequest signInRequest);

    public SignOutResponse signOut(SignOutRequest signOutRequest);

    public List<Book> searchBook(String title, String author, String isbn);
}
