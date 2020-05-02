package com.mywork.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mywork.springboot.pojo.BorrowRecord;
import com.mywork.springboot.pojo.Msg;
import com.mywork.springboot.pojo.Reader;
import com.mywork.springboot.pojo.ReturnRecord;
import com.mywork.springboot.service.ReturnRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReturnRecordController {

    @Autowired
    private ReturnRecordService returnRecordServiceImpl;

    @GetMapping(value = "/get_allReturnRecord")
    @ResponseBody
    public Msg get_allBorrowRecord(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
                                   Reader reader,ReturnRecord record) {
        PageHelper.startPage(pn,5);
        List<ReturnRecord> list = returnRecordServiceImpl.selAllRecordByReaderId(reader,record);
        PageInfo pageInfo = new PageInfo(list,5);
        return Msg.success().add("pageInfo",pageInfo);
    }

    //删除
    @GetMapping(value = "/delete_returnRecord")
    @ResponseBody
    public Msg delete_returnRecord(Integer recordId) {
            int index = returnRecordServiceImpl.delReturnRecordById(recordId);
        if(index > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
}
