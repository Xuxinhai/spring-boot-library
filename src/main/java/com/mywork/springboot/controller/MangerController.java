package com.mywork.springboot.controller;

import com.mywork.springboot.pojo.Manager;
import com.mywork.springboot.pojo.Msg;
import com.mywork.springboot.pojo.Reader;
import com.mywork.springboot.service.ManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/manager")
public class MangerController {

    @Autowired
    private ManagerService managerServiceImpl;

    //修改密码
    @PostMapping("/update_managerPassword")
    @ResponseBody
    public Msg update_readerPassword(Manager manager, HttpServletRequest request) {
        int index = managerServiceImpl.updPass(manager);
        if(index > 0) {
            Manager m = (Manager) request.getSession().getAttribute("manager");
            m.setManagerPassword(manager.getManagerPassword());
            request.getSession().setAttribute("manager",m);
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

}
