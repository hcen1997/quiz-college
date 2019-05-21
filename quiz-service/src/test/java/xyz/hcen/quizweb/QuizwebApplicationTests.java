package xyz.hcen.quizweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.hcen.quizweb.mapper.PersonMapper;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuizwebApplicationTests {
    @Autowired
    PersonMapper personMapper;

    @Test
    @Rollback
    public void contextLoads() {
        String name = "小明";
        int exp = 8;
        personMapper.updateExpbyName(name,exp);
        Map person = personMapper.queryPerson(name);
        int expk = (int) person.get("exp");

        assert expk == 8;
    }

}
