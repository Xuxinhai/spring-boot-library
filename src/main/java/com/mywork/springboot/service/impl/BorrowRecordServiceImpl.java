package com.mywork.springboot.service.impl;

import com.fasterxml.jackson.core.json.UTF8DataInputJsonParser;
import com.mywork.springboot.mapper.BookMapper;
import com.mywork.springboot.mapper.BorrowRecordMapper;
import com.mywork.springboot.mapper.ReturnRecordMapper;
import com.mywork.springboot.pojo.BorrowRecord;
import com.mywork.springboot.pojo.Reader;
import com.mywork.springboot.pojo.ReturnRecord;
import com.mywork.springboot.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {

    @Autowired
    private BorrowRecordMapper borrowRecordMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private ReturnRecordMapper returnRecordMapper;

    @Override
    public int insBorrowRecord(BorrowRecord record) {
        return borrowRecordMapper.insBorrowRecord(record);
    }

    @Override
    public List<BorrowRecord> selAllRecordByReaderId(Reader reader,BorrowRecord record) {
        return borrowRecordMapper.selAllRecordByReaderId(reader,record);
    }

    @Transactional
    @Override
    public int returnBook(BorrowRecord record) {
        //修改归还状态
        int upd1 = borrowRecordMapper.updateReturnStaById(record.getRecordId());

        //增加书籍库存
        int upd2 = bookMapper.updBookNumById_plus(record.getBookId());

        //增加一条归还记录
        ReturnRecord returnRecord = new ReturnRecord();
        returnRecord.setBookId(record.getBookId());
        returnRecord.setReaderId(record.getReaderId());
        returnRecord.setBorrowDate(record.getBorrowDate());
        returnRecord.setReturnDate(new Timestamp(System.currentTimeMillis()));

        int ins = returnRecordMapper.insReturnRecord(returnRecord);

        if(upd1>0 && upd2>0 && ins>0) {
            return 1;
        }

        return 0;
    }

    @Override
    public int delBorrowRecordById(Integer recordId) {
        return borrowRecordMapper.delBorrowRecordById(recordId);
    }
}
