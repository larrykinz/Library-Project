package org.example.web;

import org.example.data.repository.StaffRepository;
import org.example.dto.request.*;
import org.example.dto.response.AddBookResponse;
import org.example.dto.response.ApiResponse;
import org.example.services.implementation.StaffServiceImpl;
import org.example.services.interfaces.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
@CrossOrigin(origins = "*")
public class StaffController {
    @Autowired
    private StaffServices staffServices;
    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody AddBookRequest addBookRequest) {

        try {
            var result = staffServices.addBook(addBookRequest);
            return new ResponseEntity<>(new ApiResponse(result,true), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(),false), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deleteBook")
    public ResponseEntity<?> deleteBook (@RequestBody DeleteBookRequest deleteBookRequest) {

        try {
            var result = staffServices.deleteBook(deleteBookRequest);
            return new ResponseEntity<>(new ApiResponse(result,true), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(),false), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/updateBook")
    public ResponseEntity<?> updateBook(@RequestBody UpdateBookRequest updateBookRequest) {
        try {
            var result = staffServices.updateBook(updateBookRequest);
            return new ResponseEntity<>(new ApiResponse(result, true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/registerStaff")
    public ResponseEntity<?> registerStaff(@RequestBody RegisterRequest registerRequest) {
        try {
            var result = staffServices.registerStaff(registerRequest);
            return new ResponseEntity<>(new ApiResponse(result, true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/loginStaff")
    public ResponseEntity<?> loginStaff(@RequestBody LoginRequest loginRequest) {
        try {
            var result = staffServices.loginStaff(loginRequest);
            return new ResponseEntity<>(new ApiResponse(result, true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }


}
