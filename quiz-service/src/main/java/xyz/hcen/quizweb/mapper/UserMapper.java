package xyz.hcen.quizweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select t.username from user t where id = #{id}")
    String queryUsernameById(@Param("id")int id);

}
