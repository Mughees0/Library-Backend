package com.rest_api.fs14backend.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table (name = "borrowers")
@NoArgsConstructor
@Data
public class Borrower {
    @Id
    @GeneratedValue()
    private UUID id;
    @OneToOne(optional = false)
    private User user;
    @OneToOne(optional = false)
    private Book book;
    @Column(nullable = false)
    private Date borrowDate;
    @Column(nullable = false)
    private Date returnDate;

    public Borrower(User user, Book book, Date borrowDate, Date returnDate) {
        this.user = user;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }
}
