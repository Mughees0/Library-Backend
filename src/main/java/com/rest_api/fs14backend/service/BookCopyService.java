package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.dto.BookCopyDto;
import com.rest_api.fs14backend.entity.Borrower;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.entity.BookCopy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public interface BookCopyService {
    public List<BookCopy> getAll();
    public BookCopy findOne(UUID id);
    public BookCopy createOne(BookCopyDto bookCopyDto);
    public void deleteOne(UUID id);
    public List<BookCopy> findAllByBookId(UUID id);
    public List<BookCopy> findAvailableByBookId(UUID id);
    public BookCopy updateOne( UUID id, BookCopyDto bookCopyDto);
    public int countAllByBookId( UUID id);
    public int countAvailableByBookId(UUID id);

}
