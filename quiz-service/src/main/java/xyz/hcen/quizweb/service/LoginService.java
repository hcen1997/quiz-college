package xyz.hcen.quizweb.service;

public interface LoginService {
    //find id by username
    long queryId(String userName);

    // query password by id
    //就算我获取了密码 又有谁能看见呢？他还能检测我的服务器端的发送接收情况？知道我的服务器和谁聊天？
    String querryPassword(Long id);
}
