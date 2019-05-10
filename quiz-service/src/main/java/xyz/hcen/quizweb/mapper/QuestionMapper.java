package xyz.hcen.quizweb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(question, answer,rightans,category,difficulty) " +
            "values(#{question}, #{answer},#{rightans},#{category},#{difficulty})")
    int insertQestion(String question,String answer,
                          String rightans,String category,int difficulty);

    @Select("select q.id,q.question,q.answer,q.rightans,q.category,q.difficulty from question q where id=#{id}")
    Map querySingleQue(int id);
}
