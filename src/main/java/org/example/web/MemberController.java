package org.example.web;

import org.example.dto.request.BorrowBookRequest;
import org.example.dto.response.ApiResponse;
import org.example.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
