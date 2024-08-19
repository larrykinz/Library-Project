package org.example.services.implementation;
import org.example.data.model.Staff;
import org.example.data.repository.BookRepository;
import org.example.data.repository.StaffRepository;
import org.example.dto.request.*;
import org.example.dto.response.*;
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
    private BookRepository bookRepository;
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
        addBookRequest.setTitle("Kingss");
        addBookRequest.setIsbn("20022");
        addBookRequest.setType(STORYBOOK);
        addBookRequest.setAuthor("King Author");
        AddBookResponse addBookResponse = staffServices.addBook(addBookRequest);
        assertThat(addBookResponse).isNotNull();
        assertThat(addBookResponse.getTitle()).isEqualTo("Kingss");
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
    @Test
    public void updateBookTest() {
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setTitle("Titans Title");
        addBookRequest.setIsbn("12345");
        addBookRequest.setType(STORYBOOK);
        addBookRequest.setAuthor("Original Author");
        AddBookResponse addBookResponse = staffServices.addBook(addBookRequest);

        assertNotNull(addBookResponse.getBookId(), "Book ID should not be null");

        UpdateBookRequest updateBookRequest = new UpdateBookRequest();
        updateBookRequest.setBookId(addBookResponse.getBookId());
        updateBookRequest.setTitle("semicolon Title");
        updateBookRequest.setIsbn("67890");
        updateBookRequest.setType(TEXTBOOK);
        updateBookRequest.setAuthor("Updated Author");

        UpdateBookResponse updateBookResponse = staffServices.updateBook(updateBookRequest);
        assertThat(updateBookResponse).isNotNull();
        assertThat(updateBookResponse.getTitle()).isEqualTo("semicolon Title");

        assertThat(updateBookResponse).isNotNull();
        assertThat(updateBookResponse.getTitle()).isEqualTo("semicolon Title");
        assertThat(updateBookResponse.getIsbn()).isEqualTo("67890");
        assertThat(updateBookResponse.getAuthor()).isEqualTo("Updated Author");
    }
    @Test
    public void RegisterStaffTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setStaffName("King Author");
        registerRequest.setPassword("1234");
        registerRequest.setEmail("king@gmail.com");

        RegisterResponse registerResponse = staffServices.registerStaff(registerRequest);
        assertThat(registerResponse).isNotNull();
        assertThat(registerResponse.getStaffName()).isEqualTo("King Author");
        assertThat(registerResponse.getEmail()).isEqualTo("king@gmail.com");
    }

    @Test
    public void loginStaffTest() {
        String staffName = "Kingilo";
        String email = "king@gmail.com";
        String password = "1234";

        Staff staff = new Staff();
        staff.setEmail(email);
        staff.setPassword(password);
        staffRepository.save(staff);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);

        LoginResponse loginResponse = staffServices.loginStaff(loginRequest);

        assertThat(loginResponse).isNotNull();
        assertThat(loginResponse.isLoggedIn()).isTrue();
        assertThat(loginResponse.getEmail()).isEqualTo(email);
        assertThat(loginResponse.getPassword()).isEqualTo(password);
    }
}