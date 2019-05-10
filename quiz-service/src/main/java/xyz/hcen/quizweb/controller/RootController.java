package xyz.hcen.quizweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.hcen.quizweb.entity.Message;
import xyz.hcen.quizweb.service.SqliteDao;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RootController {
    @Autowired
    SqliteDao sqliteDao;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Object root(){
        Map<String,String> info = new HashMap<>();
        info.put("info","this is the root of service");
        return info;
    }

    @RequestMapping(value = "/sqliteTest")
    public Message sqliteTest(){
        Message message = new Message();
        message.setStatus(1);
        //query username from build in sqlite
        String username = "";
        username =sqliteDao.queryUsername(1);
        message.setBody("username: " + username);
        return message;
    }
}
