package com.mywork.springboot.service;

import com.mywork.springboot.pojo.Manager;
import com.mywork.springboot.pojo.Reader;

public interface LoginService {

    Reader selByNameAndPass(String name, String password);

    Manager selManByNameAndPass(String name,String password);

}
