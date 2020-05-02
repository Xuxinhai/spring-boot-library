package com.mywork.springboot.service.impl;

import com.mywork.springboot.mapper.BookMapper;
import com.mywork.springboot.pojo.Book;
import com.mywork.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;



    @Override
    public List<Book> selAllBook(String bookName, String bookAuthor, String bookPub, Integer bookstyleId) {
        return bookMapper.selAllBook(bookName,bookAuthor,bookPub,bookstyleId);
    }

    @Override
    public Book selBookDetails(Integer bookId) {
        return bookMapper.selBookDetailsById(bookId);
    }

    @Override
    public int updBookNumById(int bookId) {
        return bookMapper.updBookNumById(bookId);
    }

    @Override
    public int delBookById(Integer bookId) {
        return bookMapper.delBookById(bookId);
    }

    @Override
    public int insBook(Book book) {
        return bookMapper.insBook(book);
    }
}

