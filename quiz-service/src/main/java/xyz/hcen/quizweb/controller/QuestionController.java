package xyz.hcen.quizweb.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.hcen.quizweb.mapper.QuestionMapper;

import java.util.HashMap;
import java.util.Map;

@RestController
public class QuestionController {
    private Log log = LogFactory.getLog(QuestionController.class);
    @Autowired
    QuestionMapper questionMapper;

    @RequestMapping("/api/question/single")
    public Map questionSingle(int id) {
        Map<String, Object> reqMap = new HashMap<>();
        String[] category={"all"};
        reqMap.put("quantity", 1);
        reqMap.put("category", category);
        Map resMap  =questionMapper.querySingleQue(id);
        return resMap;
    }
//    @RequestParam(value = "quantity")@RequestParam(value = "category")
    @RequestMapping("/api/question/list")
    public Map questionList(int quantity,
                        String[] category) {
        quantity=1;
        category=null;
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("quantity", quantity);
        resultMap.put("category", category);
        return resultMap;
    }

    @RequestMapping(value = "/api/question/add",method = RequestMethod.POST)
    public String addQuestion(@RequestParam(value = "question")String question,
                              @RequestParam(value = "answer")String answer,
                              @RequestParam(value = "rightans")String rightans,
                              @RequestParam(value = "category")String category,
                              @RequestParam(value = "difficulty")int difficulty){
        String result ="";//"success error fail
        try {
             if(questionMapper.insertQestion(question,answer,rightans,
                    category,difficulty)==1){
                result="success";
             }else {
                 result="fail";
             }
        }catch (Exception e){
            result = "error ";
        }
        return result;
    }

}
