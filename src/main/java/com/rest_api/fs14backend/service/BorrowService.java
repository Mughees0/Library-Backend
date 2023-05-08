package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.dao.AuthRequest;
import com.rest_api.fs14backend.dao.BorrowDao;
import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.entity.Borrower;
import com.rest_api.fs14backend.entity.User;

import java.util.List;
import java.util.UUID;

public interface BorrowService {

    public List<Borrower> findAll();
    public Borrower findOne (UUID id);
    public Borrower createOne(BorrowDao borrowDao);
    public Borrower updateOne(UUID id,BorrowDao borrowDao);

    public void deleteOne(UUID id);
}
