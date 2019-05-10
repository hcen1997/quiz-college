package xyz.hcen.quizweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.hcen.quizweb.constant.Constant;
import xyz.hcen.quizweb.entity.Message;
import xyz.hcen.quizweb.service.LoginService;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/api/login",method = RequestMethod.GET)
    public Message getloginTest(){
        Message loginMessage = new Message();
        loginMessage.setStatus(Constant.LoginStatus.SUCCESS.getKey());
        loginMessage.setBody(Constant.LoginStatus.SUCCESS.getBody());

        return loginMessage;
    }

    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    public Message login(){
        Message loginMessage = new Message();
        loginMessage.setStatus(Constant.LoginStatus.SUCCESS.getKey());
        loginMessage.setBody(Constant.LoginStatus.SUCCESS.getBody());

        return loginMessage;
    }


}
