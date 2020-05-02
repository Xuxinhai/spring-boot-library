package com.mywork.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mywork.springboot.pojo.Book;
import com.mywork.springboot.pojo.BorrowRecord;
import com.mywork.springboot.pojo.Msg;
import com.mywork.springboot.service.BookService;
import com.mywork.springboot.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookServiceImpl;
    @Autowired
    private BorrowRecordService borrowRecordServiceImpl;

    @GetMapping(value = "/get_allBook")
    @ResponseBody
    public Msg get_allBook(@RequestParam(value = "pn",defaultValue = "1") Integer pn,String bookName,
                           String bookAuthor,String bookPub, Integer bookstyleId) {

        PageHelper.startPage(pn,5);
        List<Book> list = bookServiceImpl.selAllBook(bookName,bookAuthor,bookPub,bookstyleId);
        PageInfo pageInfo = new PageInfo(list,5);
        return Msg.success().add("pageInfo",pageInfo);
    }

    @GetMapping(value = "/bookDetails.html")
    public String get_bookDetails(Integer bookId, HttpServletRequest request) {

        Book book = bookServiceImpl.selBookDetails(bookId);
        request.getSession().setAttribute("book",book);

        return "reader/bookDetails";
    }

    @GetMapping(value = "/update_bookNum")
    @ResponseBody
    public Msg update_bookNum(int bookId, int readerId,HttpServletRequest request) {
        int index = bookServiceImpl.updBookNumById(bookId);

        if(index > 0) {
                //增加一条借阅记录
            BorrowRecord record = new BorrowRecord();
            record.setBookId(bookId);
            record.setReaderId(readerId);
            long time = new Date().getTime();
            record.setBorrowDate(new Timestamp(time));
            record.setShouldReturnDate(new Timestamp(time+20*24*3600*1000));
            int ins = borrowRecordServiceImpl.insBorrowRecord(record);
            System.out.println(new Timestamp(time));
            if(ins > 0) {
                return Msg.success();
            }

        }

        return Msg.fail();

    }

    //获取书籍详细信息
    @GetMapping(value = "/get_bookDetails")
    @ResponseBody
    public Msg man_get_bookDetails(Integer bookId, HttpServletRequest request) {

        Book book = bookServiceImpl.selBookDetails(bookId);
        request.getSession().setAttribute("book",book);

        return Msg.success();
    }

    //删除
    @GetMapping(value = "/delete_book")
    @ResponseBody
    public Msg delete_book(Integer bookId) {
        int index = bookServiceImpl.delBookById(bookId);
        if(index > 0) {
            return Msg.success();
        }

        return Msg.fail();
    }

    //添加
    @GetMapping(value = "/insert_book")
    @ResponseBody
    public Msg insert_book(Book book) {
        int index = bookServiceImpl.insBook(book);
        if(index > 0) {
            return Msg.success();
        }

        return Msg.fail();
    }
}
