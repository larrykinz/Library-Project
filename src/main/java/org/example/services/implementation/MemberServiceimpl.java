package org.example.services.implementation;

import org.example.data.model.Book;
import org.example.data.repository.BookRepository;
import org.example.data.repository.MemberRepository;
import org.example.dto.request.BorrowBookRequest;
import org.example.dto.request.ReturnBookRequest;
import org.example.dto.request.SearchBookRequest;
import org.example.dto.response.BorrowBookResponse;
import org.example.dto.response.ReturnBookResponse;
import org.example.dto.response.SearchBookResponse;
import org.example.exception.BookAlreadyExistException;
import org.example.exception.BookDoesNotExistException;
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
    public List<Book> searchBook(String title, String author, String isbn) {
        List<Book> books = new ArrayList<>();

        if (title != null && !title.isEmpty()) {
            books = bookRepository.findByTitleContainingIgnoreCase(title);
        } else if (author != null && !author.isEmpty()) {
            books = bookRepository.findByAuthorContainingIgnoreCase(author);
        } else if (isbn != null && !isbn.isEmpty()) {
            books = bookRepository.findByIsbnContainingIgnoreCase(isbn);
        } else {
            books = bookRepository.findAll();
        }

        return books;
    }
    public BorrowBookResponse borrowBook(BorrowBookRequest borrowBookRequest) {
        Book bookResult = null;
        for (Book book : bookRepository.findAll()) {
            if(book.getId().equals(borrowBookRequest.getId())){
                book.setAvailable(false);
                bookResult = bookRepository.save(book);
                break;
            }
        }
        if(bookResult == null)throw new BookDoesNotExistException("Book Not Found");
        BorrowBookResponse borrowBookResponse = new BorrowBookResponse();
        borrowBookResponse.setId(bookResult.getId());
        borrowBookResponse.setTitle(bookResult.getTitle());
        borrowBookResponse.setAuthor(bookResult.getAuthor());
        borrowBookResponse.setIsbn(bookResult.getIsbn());
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

}
