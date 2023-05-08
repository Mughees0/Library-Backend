package com.rest_api.fs14backend.serviceImpl;

import com.rest_api.fs14backend.dao.BorrowDao;
import com.rest_api.fs14backend.entity.*;
import com.rest_api.fs14backend.mapper.BookMapper;
import com.rest_api.fs14backend.mapper.BorrowMapper;
import com.rest_api.fs14backend.repository.BookRepository;
import com.rest_api.fs14backend.repository.BorrowerRepository;
import com.rest_api.fs14backend.service.BookService;
import com.rest_api.fs14backend.service.BorrowService;
import com.rest_api.fs14backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowerRepository borrowerRepository;
    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @Autowired
    BorrowMapper borrowMapper;

    @Override
    public List<Borrower> findAll(){
        return borrowerRepository.findAll();
    }

    @Override
    public Borrower findOne (UUID id){
        System.out.println("##### " + borrowerRepository.findById(id));
        return borrowerRepository.findById(id).orElse(null);
    }
    @Override
    public Borrower createOne(BorrowDao borrowDao) {
        UUID userId = borrowDao.getUserId();
        User foundUser = userService.getUserById(userId);
        UUID bookId = borrowDao.getBookId();
        Book foundBorrower = bookService.findOne(bookId);
        Borrower newBorrower  =  borrowMapper.toBorrow(borrowDao,foundUser,foundBorrower);
        return borrowerRepository.save(newBorrower);
    }

    @Override
    public Borrower updateOne(UUID id,BorrowDao borrowDao){
        Borrower foundBorrower =  borrowerRepository.findById(id).orElse(null);

        if(foundBorrower != null){
            foundBorrower.setBook(bookService.findOne(borrowDao.getBookId()));
            foundBorrower.setUser(userService.getUserById(borrowDao.getUserId()));
            foundBorrower.setBorrowDate(borrowDao.getBorrowDate());
            foundBorrower.setReturnDate(borrowDao.getReturnDate());
            return borrowerRepository.save(foundBorrower);
        }
        return null;
    }

    @Override
    public void deleteOne(UUID id){
        borrowerRepository.deleteById(id);
    }
}


