package xyz.hcen.quizweb.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.hcen.quizweb.mapper.QuestionMapper;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author hcen1997
 */
@CrossOrigin
@RestController
public class QuestionController {
    private Log log = LogFactory.getLog(QuestionController.class);
    @Autowired
    QuestionMapper questionMapper;

    @RequestMapping("/api/question/single")
    public Map questionSingle(int id) {
        return questionMapper.querySingleQue(id);
    }
//    @RequestParam(value = "quantity")@RequestParam(value = "category")

    @RequestMapping("/api/question/list")
    public ArrayList<Map> questionList(int quantity,
                                          String category) {
//        quantity=1;
//        category=null;
        String[] cats = category.split("\\|");
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i=0;i<cats.length;i++){
            //
            if(i+1==cats.length){
                numbers.add(quantity);
                break;
            }
            int part = 0;
            do{
                part =(int) Math.round(((double)quantity)* Math.random());
            }while (part==quantity);
            numbers.add(part);
            quantity-=part;
        }
        // cats [] numbers[]
        ArrayList<Map> questionList = new ArrayList<>();
        for (int i = 0; i < cats.length; i++) {
            ArrayList<Map> a0 = questionMapper.queryListbyCategory(cats[i],numbers.get(i));
            questionList.addAll(a0);
        }
        // 根据不同的类别调用不同的类别service

        return questionList;
    }

    @RequestMapping(value = "/api/question/add",method = RequestMethod.POST)
    public String addQuestion(@RequestParam(value = "question")String question,
                              @RequestParam(value = "answer")String answer,
                              @RequestParam(value = "rightans")String rightans,
                              @RequestParam(value = "category")String category,
                              @RequestParam(value = "difficulty")int difficulty){
        //"success error fail
        String result ="";
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
