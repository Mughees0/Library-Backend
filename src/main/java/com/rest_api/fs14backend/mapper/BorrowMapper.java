package com.rest_api.fs14backend.mapper;

import com.rest_api.fs14backend.dto.BorrowDto;
import com.rest_api.fs14backend.entity.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class BorrowMapper {
    public Borrower toBorrow(User user, BookCopy bookCopy, Date borrowDate, Date returnDate){
        return new Borrower(user,bookCopy,borrowDate,returnDate);
    }
}
