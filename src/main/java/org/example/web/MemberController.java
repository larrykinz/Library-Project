package org.example.web;

import org.example.dto.request.*;
import org.example.dto.response.ApiResponse;
import org.example.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @PostMapping("/borrowBook")
    public ResponseEntity<?> borrowBook(@RequestBody BorrowBookRequest borrowBookRequest) {
        try {
            var result = memberService.borrowBook(borrowBookRequest);
            return new ResponseEntity<>(new ApiResponse(result, true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }
        @PostMapping("/returnBook")
        public ResponseEntity<?> returnBook(@RequestBody ReturnBookRequest returnBookRequest) {
            try {
                var result = memberService.returnBook(returnBookRequest);
                return new ResponseEntity<>(new ApiResponse(result, true), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.BAD_REQUEST);
            }
        }
    @PostMapping("/registerMember")
    public ResponseEntity<?> registerMember(@RequestBody RegisterMemberRequest registerMemberRequest) {
        try {
            var result = memberService.registerMember(registerMemberRequest);
            return new ResponseEntity<>(new ApiResponse(result, true), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest) {
        try {

            var result = memberService.signIn(signInRequest);
            return new ResponseEntity<>(new ApiResponse(result, true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/signOut")
    public ResponseEntity<?> signOut(@RequestBody SignOutRequest signOutRequest) {
        try {
            var result = memberService.signOut(signOutRequest);
            return new ResponseEntity<>(new ApiResponse(result, true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }

}




