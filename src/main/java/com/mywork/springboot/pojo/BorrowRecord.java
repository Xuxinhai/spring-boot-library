package com.mywork.springboot.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class BorrowRecord {

    private Integer recordId;
    private Integer readerId;
    private Integer bookId;
    private Timestamp borrowDate;
    private Integer ReturnStatus;
    private Timestamp shouldReturnDate;

    private Reader reader;
    private Book book;

    public Integer getReturnStatus() {
        return ReturnStatus;
    }

    public void setReturnStatus(Integer returnStatus) {
        ReturnStatus = returnStatus;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Timestamp getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Timestamp borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Timestamp getShouldReturnDate() {
        return shouldReturnDate;
    }

    public void setShouldReturnDate(Timestamp shouldReturnDate) {
        this.shouldReturnDate = shouldReturnDate;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
