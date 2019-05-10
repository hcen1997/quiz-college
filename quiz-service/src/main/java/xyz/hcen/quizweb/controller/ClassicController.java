package xyz.hcen.quizweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClassicController {

    @RequestMapping(value = "/api/question/add",method = RequestMethod.GET)
    public String getQuestionPage(){
        return "/InsertQuestion.html";
    }
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String getAdminPage(){
        return "/Admin.html";
    }
}
