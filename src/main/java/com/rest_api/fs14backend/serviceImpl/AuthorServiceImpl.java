package com.rest_api.fs14backend.serviceImpl;

import com.rest_api.fs14backend.entity.Author;
import com.rest_api.fs14backend.repository.AuthorRepository;
import com.rest_api.fs14backend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public Author createAuthor(Author author) {
       return authorRepository.save(author);
    }

    @Override
    public Author getUserById(UUID authorId) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        return optionalAuthor.get();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(UUID id,Author author) {
        Author existingAuthor = authorRepository.findById(id).orElse(null);
        if(existingAuthor != null) {
            existingAuthor.setEmail(author.getEmail());
            existingAuthor.setAuthorName(author.getAuthorName());
            existingAuthor.setPhone(author.getPhone());
            return authorRepository.save(existingAuthor);
        }
        return null;
    }

    @Override
    public void deleteAuthor(UUID authorId) {
    authorRepository.deleteById(authorId);

    }
}
