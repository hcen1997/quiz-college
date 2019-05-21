package xyz.hcen.quizweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.hcen.quizweb.mapper.PersonMapper;

import java.util.Map;

@CrossOrigin
@RestController
public class PersonController {
    @Autowired
    PersonMapper personMapper;

    @RequestMapping(value = "/api/person/add",method = RequestMethod.GET)
    public int addUser(String name){
        System.out.println(name);
        int res = personMapper.insertPerson(name);
//        Message loginMessage = new Message();
//        loginMessage.setStatus(Constant.LoginStatus.SUCCESS.getKey());
//        loginMessage.setBody(Constant.LoginStatus.SUCCESS.getBody());
//
//        return loginMessage;
        return res;
    }

    @RequestMapping(value = "/api/person",method = RequestMethod.POST)// never trust client
    public Object login(@RequestBody Map requestMap){
        System.out.println("pass"+requestMap.get("username"));
        Object personInfo = null;
        System.out.println("hihihhih");
        String username = (String) requestMap.get("username");
        String password = (String) requestMap.get("password");
//        System.out.println(personMapper.queryPerson(username)); null
//        if(personMapper.queryPerson(username)==null){
//            personMapper.insertPerson(username);
//            personInfo = personMapper.queryPerson(username);
//        }

        personInfo = personMapper.queryPerson(username);

        // 登录成功 用户信息返回 登录不成功 查无此人 新建此人
        return personInfo;
    }

    @RequestMapping(value = "/api/person/updateExp",method = RequestMethod.POST)
    public int updateExp(@RequestBody Map requestMap){
        //username exp
        String username = (String) requestMap.get("name");
        int exp = (int)requestMap.get("exp");
        Map person = personMapper.queryPerson(username);
        int lastExp = (int) person.get("exp");
        int res = 0;
        if(exp<lastExp){
            return -1;
        }else {
            res = personMapper.updateExpbyName(username,exp);
        }
        return res;
    }
}
