package com.mywork.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mywork.springboot.pojo.Book;
import com.mywork.springboot.pojo.Msg;
import com.mywork.springboot.pojo.Reader;
import com.mywork.springboot.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ReaderController {

    @Autowired
    private ReaderService readerServiceImpl;


    //更新信息
    @PostMapping("/reader/update_reader")
    @ResponseBody
    public Msg update_reader(Reader reader, HttpServletRequest request) {
        int index = readerServiceImpl.updReaderById(reader);
        if(index > 0) {
            Reader r = (Reader) request.getSession().getAttribute("reader");
            r.setReaderPhone(reader.getReaderPhone());
            r.setReaderEmail(reader.getReaderEmail());
            request.getSession().setAttribute("reader",r);
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //修改密码
    @PostMapping("/reader/update_readerPassword")
    @ResponseBody
    public Msg update_readerPassword(String password,int id,HttpServletRequest request) {
        int index = readerServiceImpl.updReaderPassById(password,id);
        if(index > 0) {
            Reader r = (Reader) request.getSession().getAttribute("reader");
            r.setReaderPassword(password);
            request.getSession().setAttribute("reader",r);
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }


    //查询所有的读者
    @GetMapping(value = "/get_allReader")
    @ResponseBody
    public Msg get_allBook(@RequestParam(value = "pn",defaultValue = "1") Integer pn,Reader reader) {

        PageHelper.startPage(pn,5);
        List<Reader> list = readerServiceImpl.selAllReader(reader);
        PageInfo pageInfo = new PageInfo(list,5);
        return Msg.success().add("pageInfo",pageInfo);
    }

    //删除
    @GetMapping("/delete_reader")
    @ResponseBody
    public Msg delete_reader(Integer readerId) {
        int index = readerServiceImpl.delReaderById(readerId);
        if(index > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //添加
    @PostMapping("/insert_reader")
    @ResponseBody
    public Msg insert_reader(Reader reader) {
        int index = readerServiceImpl.insReader(reader);
        if(index > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }




}
