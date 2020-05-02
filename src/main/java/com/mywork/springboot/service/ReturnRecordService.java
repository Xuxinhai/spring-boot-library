package com.mywork.springboot.service;

import com.mywork.springboot.pojo.Reader;
import com.mywork.springboot.pojo.ReturnRecord;

import java.util.List;

public interface ReturnRecordService {

//    int insReturnRecord(ReturnRecord record);

    List<ReturnRecord> selAllRecordByReaderId(Reader reader,ReturnRecord record);

    int delReturnRecordById(Integer recordId);
}
