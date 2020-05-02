package com.mywork.springboot.service.impl;

import com.mywork.springboot.mapper.BookstyleMapper;
import com.mywork.springboot.pojo.Bookstyle;
import com.mywork.springboot.service.BookstyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstyleServiceImpl implements BookstyleService {

    @Autowired
    private BookstyleMapper bookstyleMapper;

    @Override
    public List<Bookstyle> selAllBookStyle() {
        return bookstyleMapper.selAllBookstyle();
    }
}
