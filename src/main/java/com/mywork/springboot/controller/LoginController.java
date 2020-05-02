package com.mywork.springboot.controller;

import com.mywork.springboot.pojo.Manager;
import com.mywork.springboot.pojo.Reader;
import com.mywork.springboot.service.LoginService;
import com.mywork.springboot.util.CpachaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;


@Controller
public class LoginController {

    @Autowired
    private LoginService loginServiceImpl;


    //获取验证码
    @RequestMapping(value="/login/get_cpacha",method = RequestMethod.GET)
    public void generateCpacha(
            @RequestParam(name="vl",required = false,defaultValue = "4") Integer vcodeLen,
            @RequestParam(name="w",required = false,defaultValue = "100") Integer width,
            @RequestParam(name="h",required = false,defaultValue = "30") Integer height,
            @RequestParam(name="type",required = true,defaultValue = "loginCpacha") String cpachaType,
            HttpServletRequest request,
            HttpServletResponse response) {
        CpachaUtil cpachaUtil = new CpachaUtil(vcodeLen,width,height);
        String generatorVCode = cpachaUtil.generatorVCode();
        request.getSession().setAttribute("code",generatorVCode);

        BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
        try {
            ImageIO.write(generatorRotateVCodeImage,"gif",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //用户登录
    @RequestMapping("/login")
    public String login(String username, String password,
                        Integer identity, String validcode, HttpServletRequest req,HttpServletResponse response) {


        //检测验证码
        String code = req.getSession().getAttribute("code").toString();

         if(!validcode.toUpperCase().equals(code.toUpperCase())) {
            req.getSession().setAttribute("error", "验证码错误");


            return "login";
        }
        if(identity==0) {   //用户为读者
            Reader reader = loginServiceImpl.selByNameAndPass(username, password);
            if(reader == null) {
                req.getSession().setAttribute("error", "用户名或密码错误");
                return "login";
            } else {
                req.getSession().setAttribute("reader",reader);
                req.getSession().setAttribute("user","reader");
                return "redirect:/reader/main.html";
            }
        } else {    //用户为管理员
            Manager manager = loginServiceImpl.selManByNameAndPass(username, password);
            if(manager == null) {
                req.getSession().setAttribute("error", "用户名或密码错误");
                return "login";
            } else {
                req.getSession().setAttribute("manager",manager);
                req.getSession().setAttribute("user","manager");
                return "redirect:/manager/main.html";
            }

        }


    }


    /*
           reader操作
    */

    //到个人中心
    @RequestMapping("/reader/readerInfo.html")
    public String to_readerInfo() {
        return "reader/readerInfo";
    }

    //到个修改密码
    @RequestMapping("/reader/alterPassword.html")
    public String alterPassword() {
        return "reader/alterPassword";
    }

    //到书籍列表
    @RequestMapping("/reader/bookList.html")
    public String booklist() {
        return "reader/bookList";
    }

    //到借阅记录
    @RequestMapping("/reader/borrowRecord.html")
    public String borrowRecord() {
        return "reader/borrowRecord";
    }

    //到还书记录
    @RequestMapping("/reader/returnedRecord.html")
    public String returnedRecord() {
        return "reader/returnedRecord";
    }



    /*-----------------------------------------------------*/


    /*manager*/
    //到修改密码
    @RequestMapping("/manager/alterPassword.html")
    public String man_alterPassword() {
        return "manager/alterPassword";
    }

    //到读者列表
    @RequestMapping("/manager/readerList.html")
    public String readerList() {
        return "manager/readerList";
    }

    //添加读者
    @RequestMapping("/manager/addReader.html")
    public String addReader() {
        return "manager/addReader";
    }


    //书籍列表
    @RequestMapping("/manager/bookList.html")
    public String man_bookList() {
        return "manager/bookList";
    }

    //添加书籍
    @RequestMapping("/manager/addBook.html")
    public String addBook() {
        return "manager/addBook";
    }

    //书籍详细信息
    @RequestMapping("/manager/bookDetails.html")
    public String bookDatails() {
        return "manager/bookDatails";
    }

    //到借书记录
    @RequestMapping("/manager/borrowRecord.html")
    public String man_borrowRecord() {
        return "manager/borrowRecord";
    }

    //到还书记录
    @RequestMapping("/manager/returnedRecord.html")
    public String man_returnedRecord() {
        return "manager/returnedRecord";
    }





}

