package xyz.hcen.quizweb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(question, answer,rightans,category,difficulty,status) " +
            "values(#{question}, #{answer},#{rightans},#{category},#{difficulty},1)")
    int insertQestion(String question,String answer,
                          String rightans,String category,int difficulty);

    @Select("select q.id,q.question,q.answer,q.rightans,q.category,q.difficulty from question q where q.id=#{id}and q.status>0")
    Map querySingleQue(int id);

    @Update("update question  q set q.status=0 where q.id=#{id}")
    int deletebyId(int id);

    @Update("update quesion q set q.question =#{question}, q.answer=#{answer}," +
            "q.rightans=#{question},q.category=#{category},q.difficulty=#{difficulty} where q.id=#{id}")
    int updateQuestion(String question,String answer,
                       String rightans,String category,int difficulty);

    @Select("SELECT * FROM question where category=#{category} and status>0 ORDER BY RANDOM() limit #{number}")
    ArrayList<Map> queryListbyCategory(String category, int number);

}
