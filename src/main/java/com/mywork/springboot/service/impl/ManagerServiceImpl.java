package com.mywork.springboot.service.impl;

import com.mywork.springboot.mapper.ManagerMapper;
import com.mywork.springboot.pojo.Manager;
import com.mywork.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public int updPass(Manager manager) {
        return managerMapper.updPass(manager);
    }
}
