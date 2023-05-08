package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.dao.BorrowDao;
import com.rest_api.fs14backend.entity.Borrower;
import com.rest_api.fs14backend.repository.BorrowerRepository;
import com.rest_api.fs14backend.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/add")
    public Borrower addBorrower(@RequestBody BorrowDao borrowDao) {
       return  borrowerService.createOne(borrowDao);
    }
    @PutMapping("/update/{id}")
    public Borrower updateBorrower(@PathVariable UUID id,@RequestBody BorrowDao borrowDao) {
        return  borrowerService.updateOne(id,borrowDao);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteOne(@PathVariable UUID id){
        borrowerService.deleteOne(id);
    }
    @GetMapping("/{id}")
    public Borrower findOne(@PathVariable UUID id){
        return borrowerService.findOne(id);
    }

}
