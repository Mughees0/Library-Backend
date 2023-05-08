package com.rest_api.fs14backend.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table (name = "borrow")
@NoArgsConstructor
@Data
public class Borrower {
    @Id
    @GeneratedValue()
    private UUID id;
    @ManyToOne
    private User user;
    @OneToOne(optional = false)
    private BookCopy bookCopy;
    @Column(nullable = false)
    private Date borrowDate;
    @Column(nullable = false)
    private Date returnDate;




    public Borrower(User user, BookCopy bookCopy, Date borrowDate, Date returnDate) {
        this.user = user;
        this.bookCopy = bookCopy;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }
}
