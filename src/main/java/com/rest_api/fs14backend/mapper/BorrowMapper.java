package com.rest_api.fs14backend.mapper;

import com.rest_api.fs14backend.dao.BorrowDao;
import com.rest_api.fs14backend.entity.*;
import org.springframework.stereotype.Component;

@Component
public class BorrowMapper {
    public Borrower toBorrow(BorrowDao borrowDao, User user, Book book){
        return new Borrower(user,book,borrowDao.getBorrowDate(),borrowDao.getReturnDate());
    }
}
