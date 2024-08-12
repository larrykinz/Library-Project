package org.example.services.implementation;

import org.example.data.model.Book;
import org.example.data.model.Member;
import org.example.data.repository.BookRepository;
import org.example.data.repository.MemberRepository;
import org.example.dto.request.*;
import org.example.dto.response.*;
import org.example.exception.*;
import org.example.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceimpl  implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BookRepository bookRepository;

    public BorrowBookResponse borrowBook(BorrowBookRequest borrowBookRequest) {
        for (Book book : bookRepository.findAll()) {
            if(book.getId().equals(borrowBookRequest.getId())){
                book.setAvailable(false);
                bookRepository.save(book);
            }
            throw new BookNotFoundException("Book Not Found");
        }

        BorrowBookResponse borrowBookResponse = new BorrowBookResponse();
        borrowBookResponse.setId(borrowBookRequest.getId());
        borrowBookResponse.setTitle(borrowBookResponse.getTitle());
        borrowBookResponse.setAuthor(borrowBookResponse.getAuthor());
        borrowBookResponse.setIsbn(borrowBookResponse.getIsbn());
        return borrowBookResponse;
    }
      public ReturnBookResponse returnBook(ReturnBookRequest returnBookRequest) {
          for (Book book : bookRepository.findAll()) {
              if (book.getId().equals(returnBookRequest.getId())) {
                  book.setAvailable(true);
                  bookRepository.save(book);
              }
              ReturnBookResponse returnBookResponse = new ReturnBookResponse();
              returnBookResponse.setBookId(book.getId());
              returnBookResponse.setTitle(book.getTitle());
              returnBookResponse.setAuthor(book.getAuthor());
              returnBookResponse.setIsbn(book.getIsbn());

              return returnBookResponse;
          }
          throw new BookDoesNotExistException("Book Not Found");
      }
      public RegisterMemberResponse registerMember(RegisterMemberRequest registerMemberRequest){
        for(Member member : memberRepository.findAll()){
            if(member.getName().equals(registerMemberRequest.getName())){
                throw new MemberAlreadyExist("Member Already Exist");
            }
            member.setName(registerMemberRequest.getName());
            member.setPassword(registerMemberRequest.getPassword());
        }
        RegisterMemberResponse registerMemberResponse = new RegisterMemberResponse();
        registerMemberResponse.setName(registerMemberRequest.getName());
        registerMemberResponse.setMessage("Successfully Registered!");
        return registerMemberResponse;

      }
      public SignInResponse signIn(SignInRequest signInRequest){
        for (Member member : memberRepository.findAll()) {
            if(member.getName().equals(signInRequest.getName())){
                member.setName(signInRequest.getName());
                member.setMemberId(signInRequest.getMemberId());
                memberRepository.save(member);
            }
            throw new MemberDosentExist("Member dosent Exist");
        }
        SignInResponse signInResponse = new SignInResponse();
        signInResponse.setName(signInRequest.getName());
        signInResponse.setMessage("Sign In Successful");
        return signInResponse;

      }
    public SignOutResponse signOut(SignOutRequest signOutRequest) {
        for (Member member : memberRepository.findAll()) {
            if (member.getName().equals(signOutRequest.getName())) {
                member.setSignedIn(false);
                memberRepository.save(member);
            }
            throw new MemberDosentExist("Member does not exist");
        }
        SignOutResponse signOutResponse = new SignOutResponse();
        signOutResponse.setName(signOutRequest.getName());
        signOutResponse.setMessage("Sign Out Successful");
        return signOutResponse;
    }




}
