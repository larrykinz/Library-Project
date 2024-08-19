package org.example.services.implementation;

import org.example.data.model.Book;
import org.example.data.model.Member;
import org.example.data.repository.BookRepository;
import org.example.data.repository.MemberRepository;
import org.example.dto.request.BorrowBookRequest;
import org.example.dto.request.ReturnBookRequest;
import org.example.dto.response.BorrowBookResponse;
import org.example.dto.response.ReturnBookResponse;
import org.example.services.interfaces.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberServiceimplTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BookRepository bookRepository;



    @Test
    public void testThatMemberCanBorrowBook() {
        Book book = new Book();
        book.setId("1l");
        book.setAvailable(true);
        bookRepository.save(book);

        BorrowBookRequest request = new BorrowBookRequest();
        request.setId("1l");

        BorrowBookResponse response = memberService.borrowBook(request);

        assertNotNull(response);
        assertEquals("1l", response.getId());
    }
    @Test
    public void testReturnBook_Success() {
        Book book = new Book();
        book.setId("1");
        book.setAvailable(false);
        bookRepository.save(book);

        ReturnBookRequest request = new ReturnBookRequest();
        request.setId("1");


        ReturnBookResponse response = memberService.returnBook(request);


        assertNotNull(response);
        assertEquals("1", response.getBookId());
        assertTrue(response.isAvailable());
    }



}