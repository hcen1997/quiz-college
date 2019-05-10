package xyz.hcen.quizweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.hcen.quizweb.mapper.UserMapper;

@Repository
public class SqliteDaoImpl implements SqliteDao {
@Autowired
UserMapper userMapper;

    @Override
    public String queryUsername(int id){
        //todo mybatis and sqlite
        String username = "admin";
        username = userMapper.queryUsernameById(1);
        return username;
    }
}
