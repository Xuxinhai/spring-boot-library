package com.mywork.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mywork.springboot.pojo.Book;
import com.mywork.springboot.pojo.BorrowRecord;
import com.mywork.springboot.pojo.Msg;
import com.mywork.springboot.pojo.Reader;
import com.mywork.springboot.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BorrowRecordController {

    @Autowired
    private BorrowRecordService borrowRecordServiceImpl;

    @GetMapping(value = "/get_allBorrowRecord")
    @ResponseBody
    public Msg get_allBorrowRecord(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
                                   Reader reader,BorrowRecord record) {
        PageHelper.startPage(pn,5);
        List<BorrowRecord> list = borrowRecordServiceImpl.selAllRecordByReaderId(reader,record);

        PageInfo pageInfo = new PageInfo(list,5);
        return Msg.success().add("pageInfo",pageInfo);
    }

    @GetMapping(value = "/returnBook")
    @ResponseBody
    public Msg returnBook(BorrowRecord record) {
       int index = borrowRecordServiceImpl.returnBook(record);
       if(index > 0) {
           return Msg.success();
       } else {
           return Msg.fail();
       }
    }

    //删除
    @GetMapping(value = "/delete_borrowRecord")
    @ResponseBody
    public Msg delete_borrowRecord(Integer recordId) {
        int index = borrowRecordServiceImpl.delBorrowRecordById(recordId);
        if(index > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

}
