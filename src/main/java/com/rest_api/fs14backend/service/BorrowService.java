package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.dto.BorrowDto;
import com.rest_api.fs14backend.entity.BookCopy;
import com.rest_api.fs14backend.entity.Borrower;

import java.util.List;
import java.util.UUID;

public interface BorrowService {

    public List<Borrower> findAll();
    public Borrower findOne (UUID id);
    public Borrower createOne(BorrowDto borrowDao);
    public Borrower updateOne(UUID id, Borrower borrower);
    public void deleteOne(UUID id);
    public void returnOne(UUID userId, UUID bookCopyId);
}
