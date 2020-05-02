package com.mywork.springboot.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Book {

    private Integer bookId;
    private Integer bookstyleId;
    private String bookName;
    private String bookAuthor;
    private String bookPub;
    private String bookLocation;
    private Integer bookNum;
    private Double bookPrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bookUpdate;
    private String bookDescription;

    private Bookstyle bookstyle;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPub='" + bookPub + '\'' +
                ", bookLocation='" + bookLocation + '\'' +
                ", bookNum=" + bookNum +
                ", bookPrice=" + bookPrice +
                ", bookUpdate=" + bookUpdate +
                ", bookDescription='" + bookDescription + '\'' +
                ", bookstyle=" + bookstyle +
                '}';
    }

    public Integer getBookstyleId() {
        return bookstyleId;
    }

    public void setBookstyleId(Integer bookstyleId) {
        this.bookstyleId = bookstyleId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPub() {
        return bookPub;
    }

    public void setBookPub(String bookPub) {
        this.bookPub = bookPub;
    }

    public String getBookLocation() {
        return bookLocation;
    }

    public void setBookLocation(String bookLocation) {
        this.bookLocation = bookLocation;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Date getBookUpdate() {
        return bookUpdate;
    }

    public void setBookUpdate(Date bookUpdate) {
        this.bookUpdate = bookUpdate;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Bookstyle getBookstyle() {
        return bookstyle;
    }

    public void setBookstyle(Bookstyle bookstyle) {
        this.bookstyle = bookstyle;
    }
}
