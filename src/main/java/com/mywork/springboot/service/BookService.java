package com.mywork.springboot.service;

import com.mywork.springboot.pojo.Book;

import java.util.List;

public interface BookService {

    List<Book> selAllBook(String bookName,String bookAuthor,
                          String bookPub, Integer bookstyleId);

    Book selBookDetails(Integer bookId);

    int updBookNumById(int bookId);

    int delBookById(Integer bookId);

    int insBook(Book book);
}
