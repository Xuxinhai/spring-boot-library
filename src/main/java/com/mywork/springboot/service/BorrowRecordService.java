package com.mywork.springboot.service;

import com.mywork.springboot.pojo.BorrowRecord;
import com.mywork.springboot.pojo.Reader;

import java.util.List;

public interface BorrowRecordService {

    int insBorrowRecord(BorrowRecord record);

    List<BorrowRecord> selAllRecordByReaderId(Reader reader, BorrowRecord record);

    int returnBook(BorrowRecord record);

    int delBorrowRecordById(Integer recordId);
}
