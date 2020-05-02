package com.mywork.springboot.service;

import com.mywork.springboot.pojo.Reader;

import java.util.List;

public interface ReaderService {

    int updReaderById(Reader reader);

    int updReaderPassById(String password,int id);

    List<Reader> selAllReader(Reader reader);

    int delReaderById(Integer readerId);

    int insReader(Reader reader);
}
