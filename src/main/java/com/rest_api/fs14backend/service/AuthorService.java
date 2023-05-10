package com.rest_api.fs14backend.service;

import com.rest_api.fs14backend.entity.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    Author createAuthor(Author author);
    Author getUserById(UUID authorId);
    List<Author> getAllAuthors();
    Author updateAuthor(UUID id, Author author);
    void deleteAuthor(UUID authorId);
}
