package org.example.services.implementation;

import org.example.data.model.Staff;
import org.example.data.repository.StaffRepository;
import org.example.dto.request.AddBookRequest;
import org.example.dto.request.DeleteBookRequest;
import org.example.dto.response.AddBookResponse;
import org.example.dto.response.DeleteBookResponse;
import org.example.exception.BookAlreadyExistException;
import org.example.exception.BookDoesNotExistException;
import org.example.services.interfaces.StaffServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.data.model.Category.STORYBOOK;
import static org.example.data.model.Category.TEXTBOOK;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StaffServiceImplTest {
    @Autowired
    private StaffServices staffServices;
    @Autowired
    private StaffRepository staffRepository;
    @BeforeEach
    void setUp() {
        staffRepository.deleteAll();
    }

    @Test
    public void addBookTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setTitle("King");
        addBookRequest.setIsbn("20022");
        addBookRequest.setType(STORYBOOK);
        addBookRequest.setAuthor("King Author");
        AddBookResponse addBookResponse = staffServices.addBook(addBookRequest);
        assertThat(addBookResponse).isNotNull();
        assertThat(addBookResponse.getTitle()).isEqualTo("King");
    }
    @Test
    public void testToAddAlreadyExistingBookThrowsException(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setTitle("King");
        addBookRequest.setIsbn("20022");
        addBookRequest.setType(STORYBOOK);
        addBookRequest.setAuthor("King Author");
        try {
            staffServices.addBook(addBookRequest);
        }catch (BookAlreadyExistException e){
            assertThat(e.getMessage()).isEqualTo("book already exist");
        }

    }
    @Test
    public void deleteBookTest(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setTitle("Title");
        addBookRequest.setIsbn("20022");
        addBookRequest.setType(TEXTBOOK);
        addBookRequest.setAuthor("King Author");
        AddBookResponse addBookResponse = staffServices.addBook(addBookRequest);

        DeleteBookRequest deleteBookRequest = new DeleteBookRequest();
        deleteBookRequest.setBookId(addBookResponse.getBookId());
        DeleteBookResponse deleteBookResponse = staffServices.deleteBook(deleteBookRequest);
        assertThat(deleteBookResponse).isNotNull();
        assertThat(deleteBookResponse.getMessage()).isEqualTo("Book deleted successfully");
    }
    @Test
    public void testToDeleteBookThrowsException(){
        DeleteBookRequest deleteBookRequest = new DeleteBookRequest();
        deleteBookRequest.setBookId("53255");
        try{
            staffServices.deleteBook(deleteBookRequest);
        }
        catch (BookDoesNotExistException e){
            assertThat(e.getMessage()).isEqualTo("book does not exist");
        }

    }

}