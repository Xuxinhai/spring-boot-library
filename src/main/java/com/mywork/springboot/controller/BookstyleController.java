package com.mywork.springboot.controller;

import com.mywork.springboot.pojo.Bookstyle;
import com.mywork.springboot.pojo.Msg;
import com.mywork.springboot.service.BookstyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookstyleController {

    @Autowired
    private BookstyleService bookstyleServiceImpl;

    @GetMapping("get_allBookstyle")
    @ResponseBody
    public Msg get_allBookstyle() {
        List<Bookstyle> list = bookstyleServiceImpl.selAllBookStyle();
        return Msg.success().add("bookstyleList",list);
    }
}
