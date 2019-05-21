package xyz.hcen.quizweb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

@Mapper
public interface PersonMapper {

        @Insert("insert into person (\n" +
                "    exp,\n" +
                "    heart,\n" +
                "    heartp,\n" +
                "    hint,\n" +
                "    medle,\n" +
                "    name,\n" +
                "    ranking,\n" +
                "    treastrl)\n" +
                "values (\n" +
                "    0,\n" +
                "    5,\n" +
                "    50,\n" +
                "    15,\n" +
                "    0,\n" +
                "    #{name},\n" +
                "    9999,\n" +
                "    0)")
        int insertPerson(String name);

        @Select("select\n" +
                "    p.exp,\n" +
                "    p.heart,\n" +
                "    p.heartp,\n" +
                "    p.hint,\n" +
                "    p.id,\n" +
                "    p.medle,\n" +
                "    p.name,\n" +
                "    p.ranking,\n" +
                "    p.treastrl\n" +
                "from person p where p.name = #{name}")
        Map queryPerson(String name);

        @Update("update person  set exp=#{exp}  where name=#{name}")
        int updateExpbyName(String name,int exp);

}
