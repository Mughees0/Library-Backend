package com.rest_api.fs14backend.mapper;

import com.rest_api.fs14backend.dto.BookDto;
import com.rest_api.fs14backend.entity.Author;
import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book toBook(BookDto bookDao, Category category, Author author){
        return new Book(bookDao.getTitle(),bookDao.getDescription(),bookDao.getIsbn(),author,category,bookDao.getPublishedDate(),bookDao.getPublisher(),bookDao.getCover());
    }
}
