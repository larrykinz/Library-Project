package org.example.services.implementation;

import org.example.data.model.Book;
import org.example.data.repository.BookRepository;
import org.example.data.repository.MemberRepository;
import org.example.dto.request.BorrowBookRequest;
import org.example.dto.request.SearchBookRequest;
import org.example.dto.response.BorrowBookResponse;
import org.example.dto.response.SearchBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceimpl {
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
        for (Book book : bookRepository.findAll()) {
            if(book.getId().equals(borrowBookRequest.getId())){


            }
        }
        return null;
    }

}
