package com.mywork.springboot.service.impl;

import com.mywork.springboot.mapper.ReturnRecordMapper;
import com.mywork.springboot.pojo.Reader;
import com.mywork.springboot.pojo.ReturnRecord;
import com.mywork.springboot.service.ReturnRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ReturnRecordServiceImpl implements ReturnRecordService {

    @Autowired
    private ReturnRecordMapper returnRecordMapper;

//    @Override
//    public int insReturnRecord(ReturnRecord record) {
//        return returnRecordMapper.insReturnRecord(record);
//    }

    @Override
    public List<ReturnRecord> selAllRecordByReaderId(Reader reader,ReturnRecord record) {
        return returnRecordMapper.selAllRecordByReader(reader,record);
    }

    @Override
    public int delReturnRecordById(Integer recordId) {
        return returnRecordMapper.delReturnRecordById(recordId);
    }
}
