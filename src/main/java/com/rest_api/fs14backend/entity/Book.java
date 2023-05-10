package com.rest_api.fs14backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import java.util.Date;
import java.util.UUID;

@Entity
@Data

@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column
    private String isbn;
    @OneToOne
    private Author author;
    @OneToOne
    private Category category;
    @Column(nullable = false)
    private Date publishedDate;
    @Column(nullable = false)
    private String publisher;
    @Column(nullable = false)
    private String cover;

    public Book(String title, String description, String isbn, Author author, Category category, Date publishedDate, String publisher, String cover) {
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.author = author;
        this.category = category;
        this.publishedDate = publishedDate;
        this.publisher = publisher;
        this.cover = cover;
    }
}

