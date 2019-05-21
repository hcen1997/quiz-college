package xyz.hcen.quizweb.service;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    //find id by username
    @Override
    public long queryId(String userName){
        if(userName.equals("admin")){
            return 1L;
        }
        //not find
        if(userName==null){
            return -1L;
        }
        return 0L;
    }
    // query password by id
    //就算我获取了密码 又有谁能看见呢？他还能检测我的服务器端的发送接收情况？知道我的服务器和谁聊天？
    @Override
    public String querryPassword(Long id){
        if(id.equals(1L)){
            return "21232f297a57a5a743894a0e4a801fc3";
        }
        return "";
    }

    //
}
