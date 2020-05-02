package com.mywork.springboot.service.impl;

import com.mywork.springboot.mapper.LoginMapper;
import com.mywork.springboot.pojo.Manager;
import com.mywork.springboot.pojo.Reader;
import com.mywork.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    //通过账号密码查询读者
    @Override
    public Reader selByNameAndPass(String name, String password) {

        return loginMapper.selByNameAndpass(name,password);
    }

    //通过账号密码查询管理员
    @Override
    public Manager selManByNameAndPass(String name, String password) {
        return loginMapper.selManByNameAndpass(name,password);
    }
}
