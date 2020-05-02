package com.mywork.springboot.service.impl;

import com.mywork.springboot.mapper.ReaderMapper;
import com.mywork.springboot.pojo.Reader;
import com.mywork.springboot.service.ReaderService;
import org.apache.catalina.valves.rewrite.ResolverImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired

    private ReaderMapper readerMapper;

    //更新信息
    @Override
    public int updReaderById(Reader reader) {
        return readerMapper.updReaderById(reader);
    }

    //修改密码
    @Override
    public int updReaderPassById(String password, int id) {
        return readerMapper.updReaderPassById(password,id);
    }

    @Override
    public List<Reader> selAllReader(Reader reader) {

        return readerMapper.selAllReader(reader);
    }

    @Override
    public int delReaderById(Integer readerId) {
        return readerMapper.delReaderById(readerId);
    }

    @Override
    public int insReader(Reader reader) {
        return readerMapper.insReader(reader);
    }
}
