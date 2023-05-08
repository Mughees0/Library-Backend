package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.dto.BorrowDto;
import com.rest_api.fs14backend.dto.ReturnDto;
import com.rest_api.fs14backend.entity.BookCopy;
import com.rest_api.fs14backend.entity.Borrower;
import com.rest_api.fs14backend.repository.BorrowerRepository;
import com.rest_api.fs14backend.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/borrow")
public class BorrowerController {

    @Autowired
    BorrowService borrowerService;

    @Autowired
    BorrowerRepository borrowerRepository;

    @GetMapping("/all")
    public List<Borrower> findAll() {
        return borrowerService.findAll();
    }
    @PostMapping("/borrowOne")
    public Borrower addBorrower(@RequestBody BorrowDto borrowDao) {
       return  borrowerService.createOne(borrowDao);
    }
    @PutMapping("/update/{id}")
    public Borrower updateBorrower(@PathVariable UUID id,@RequestBody Borrower borrower) {
        return  borrowerService.updateOne(id,borrower);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteOne(@PathVariable UUID id){
        borrowerService.deleteOne(id);
    }
    @GetMapping("/{id}")
    public Borrower findOne(@PathVariable UUID id){
        return borrowerService.findOne(id);
    }
    @PostMapping("/returnOne")
    public void returnOne(@RequestBody ReturnDto returnDto){
        borrowerService.returnOne(returnDto.getUserId(),returnDto.getBookCopyId());
    }

}
