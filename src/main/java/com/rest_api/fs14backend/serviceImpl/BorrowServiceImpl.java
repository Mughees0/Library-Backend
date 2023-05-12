package com.rest_api.fs14backend.serviceImpl;

import com.rest_api.fs14backend.dto.BookCopyDto;
import com.rest_api.fs14backend.dto.BorrowDto;
import com.rest_api.fs14backend.entity.*;
import com.rest_api.fs14backend.mapper.BorrowMapper;
import com.rest_api.fs14backend.repository.BorrowerRepository;
import com.rest_api.fs14backend.service.BookService;
import com.rest_api.fs14backend.service.BorrowService;
import com.rest_api.fs14backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowerRepository borrowerRepository;
    @Autowired
    BookCopyServiceImpl bookCopyService;
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
    public Borrower createOne(BorrowDto borrowDto) {
        User User = userService.getUserById(borrowDto.getUserId());
        UUID bookId = borrowDto.getBookId();


        List<BookCopy> bookCopies = bookCopyService.getAll();

        BookCopy firstAvailableCopy = null;

        for (BookCopy copy : bookCopies) {
            if (copy.getBook().getId().equals(bookId) && !copy.getStatus()) {
                continue;
            } else if (copy.getBook().getId().equals(bookId) && copy.getStatus() ){
                copy.setStatus(false);
                firstAvailableCopy = copy;
                BookCopyDto bookCopyDto = new BookCopyDto(copy.getBook().getId(),copy.getStatus());
                bookCopyService.updateOne(copy.getId(),bookCopyDto);
                break;
            }
        }

        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        // Add 3 weeks to the current date
        calendar.add(Calendar.WEEK_OF_YEAR, 3);
        Date threeWeeksAhead = calendar.getTime();

        Borrower borrower = borrowMapper.toBorrow(User,firstAvailableCopy, currentDate, threeWeeksAhead);
        return borrowerRepository.save(borrower);
    }

    @Override
    public void returnOne(UUID userId, UUID bookCopyId) {
        List<Borrower> borrowedBooks = borrowerRepository.findAll();

        for (Borrower book : borrowedBooks) {
            if (book.getUser().getId().equals(userId) && book.getBookCopy().getId().equals(bookCopyId)&& book.getBookCopy().getStatus() == false) {
                book.getBookCopy().setStatus(true);
                BookCopyDto bookCopyDto = new BookCopyDto(book.getBookCopy().getBook().getId(),book.getBookCopy().getStatus());
                BookCopy newcopy =bookCopyService.updateOne(book.getBookCopy().getId(),bookCopyDto);
                borrowerRepository.deleteById(book.getId());
                break;
            }
        }
    }
    @Override
    public List<Borrower> findAllBorrowedBooks( UUID userId){
        List<Borrower> borrowedBooks = borrowerRepository.findAll();
        List<Borrower> foundBooks = new ArrayList<Borrower>();
        for (Borrower book : borrowedBooks) {
            if (book.getUser().getId().equals(userId) && !book.getBookCopy().getStatus()) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
    @Override
    public Borrower updateOne(UUID id, Borrower borrower){
        Borrower foundBorrower =  borrowerRepository.findById(id).orElse(null);

        if(foundBorrower != null){
            foundBorrower.setBookCopy(bookCopyService.findOne(borrower.getBookCopy().getId()));
            foundBorrower.setUser(userService.getUserById(borrower.getUser().getId()));
            foundBorrower.setBorrowDate(borrower.getBorrowDate());
            foundBorrower.setReturnDate(borrower.getReturnDate());
            return borrowerRepository.save(foundBorrower);
        }
        return null;
    }

    @Override
    public void deleteOne(UUID id){
        borrowerRepository.deleteById(id);
    }

}


